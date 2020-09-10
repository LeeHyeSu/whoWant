package dongduk.cs.ssd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Inquiry;
import dongduk.cs.ssd.service.InquiryServiceImpl;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	private final String INQ_FORM = "inquiry";
	
	@Autowired
	private InquiryServiceImpl inquiryService;
	
	private int projectId;
	private String referer;

	@GetMapping
	public String form(HttpServletRequest request, 
			@RequestParam("projectId") String projectId, Model model) {		
		referer = request.getHeader("Referer");
		System.out.println(referer);
		this.projectId = Integer.parseInt(projectId);
		return INQ_FORM;
	}
	
	@PostMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("title") String title,
			@RequestParam("category") String category,
			@RequestParam("question") String question,
			Model model) throws Exception {
		
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		Inquiry inq = new Inquiry();
		inq.setTitle(title);
		inq.setCategory(category);
		inq.setQuestion(question);
		inq.setInqDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		inq.setIsAnswer("0");
		inq.setUsername(userSession.getAccount().getUsername());
		inq.setProjectId(projectId);
		
		String[] check = request.getParameterValues("isSecret");
		if(check[0].equals("1")) inq.setIsSecret("1");
		else inq.setIsSecret("0");
		
		inquiryService.insertInquiry(inq);
		
		return new ModelAndView("redirect:" + referer);
	}
	
}
