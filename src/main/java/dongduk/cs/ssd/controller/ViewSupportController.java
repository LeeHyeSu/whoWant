package dongduk.cs.ssd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Support;
import dongduk.cs.ssd.service.SupportServiceImpl;

@Controller
public class ViewSupportController {
	
	@Autowired
	private SupportServiceImpl supportService;
	
	@RequestMapping("/mySupports") // 나의 후원 현황 
	public String myProjects(HttpServletRequest request, Model model) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		List<Support> supports = supportService.getSupportsByUsername(userSession.getAccount().getUsername());
		model.addAttribute("supports", supports);
		
		return "mySupports";
	}
	
	@RequestMapping("/supports")	// 프로젝트 별 후원 현황
	public String viewSupport(HttpServletRequest request, Model model) { 
		List<Support> sp = supportService.getSupportsByProject(Integer.parseInt(request.getParameter("projectId")));
		model.addAttribute("supports", sp);
		model.addAttribute("project", request.getParameter("project"));
		return "supports";
	}
}
