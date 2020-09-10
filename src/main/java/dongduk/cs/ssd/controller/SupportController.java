package dongduk.cs.ssd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Product;
import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.model.Support;
import dongduk.cs.ssd.service.ProductServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;
import dongduk.cs.ssd.service.SupportServiceImpl;

@Controller
@RequestMapping("/support")
public class SupportController {
	private static final String STEP1_FORM_VIEW = "supportProject1";
	private static final String STEP2_FORM_VIEW = "supportProject2";
	private static final String RESULT_VIEW = "projectDone";
	
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private SupportServiceImpl supportService;
	
	private Project pj;			// 후원 프로젝트
	private Product pd;			// 후원 상품
	private UserSession userSession;
	
	@RequestMapping("/step1")	
	public ModelAndView step1(HttpServletRequest request, Model model) {	
		pj = projectService.getProject(Integer.parseInt(request.getParameter("projectId")));
		userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		if(userSession.getAccount().getUsername().equals(pj.getUsername())) {		// 로그인한 유저가 자신의 프로젝트 후원에 접근했을 때
			return new ModelAndView("error", "message", "자신이 올린 프로젝트에는 후원할 수 없습니다.");	
		}
		if(supportService.getSupport(userSession.getAccount().getUsername(), request.getParameter("projectId")) != null) {	// 이미 후원한 프로젝트일 때
			return new ModelAndView("error", "message", "이미 후원한 프로젝트입니다.");
		}
		
		return new ModelAndView(STEP1_FORM_VIEW, "project", pj);
	}
	
	@RequestMapping("/step2/{productId}")	// 상품을 선택한 경우
	public String step2ForProduct(@PathVariable String productId,
			HttpServletRequest request, Model model) {
		pd = productService.getProduct(Integer.parseInt(productId));	// 상품 정보 가져오기
		model.addAttribute("product", pd);
		
		model.addAttribute("amount", request.getParameter("amount"));
		model.addAttribute("project", pj);
		return STEP2_FORM_VIEW;		
	}
	
	@RequestMapping("/step2")	// 상품을 선택하지 않았거나 상품이 없는 프로젝트의 경우
	public String step2(HttpServletRequest request, Model model) {
		model.addAttribute("amount", "1000");
		model.addAttribute("project", pj);
		return STEP2_FORM_VIEW;
	}
	
	@RequestMapping("/done")	
	public String support(HttpServletRequest request, Model model) {
		Support sp = new Support();
		sp.setUsername(userSession.getAccount().getUsername());
		sp.setProjectId(pj.getProjectId());
		if(pd == null) sp.setProductId(0);		// 선택한 상품이 없는 경우 0 설정
		else sp.setProductId(pd.getProductId());
		sp.setAmount(Integer.parseInt(request.getParameter("amount")));
		sp.setSupportDate(currentTime());
		sp.setPaymentOption(request.getParameter("paymentOption"));
		sp.setRequest(request.getParameter("request"));
		sp.setProjectName(pj.getName());
		if(pd == null) sp.setProductName("");
		else sp.setProductName(pd.getName());
		sp.setSupporterName(userSession.getAccount().getName());
		sp.setPhonenum(userSession.getAccount().getPhonenum());
		sp.setShipAddress(userSession.getAccount().getPostcode() + " " + userSession.getAccount().getAddress()
				+ " " + userSession.getAccount().getDetailAddress());
		
		supportService.insertSupport(sp);
		
		String result = "후원";
		model.addAttribute("result", result);
		
		return RESULT_VIEW;	
	}
	
	public String currentTime() {	// 현재 시간 구하기
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dayTime.format(new Date(time));
		
		return str;
	}
	
}
