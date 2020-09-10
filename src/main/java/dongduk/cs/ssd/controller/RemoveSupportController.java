package dongduk.cs.ssd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Support;
import dongduk.cs.ssd.service.ProjectServiceImpl;
import dongduk.cs.ssd.service.SupportServiceImpl;

@Controller
public class RemoveSupportController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private SupportServiceImpl supportService;

	@RequestMapping("/removeSupport")
	public ModelAndView removeProject(HttpServletRequest request, Model model) { // 후원 취소
		int pjId = Integer.parseInt(request.getParameter("projectId"));

		if (projectService.getProject(pjId).getDaysUntilDeadline() < 0) {	
			return new ModelAndView("error", "message", "마감된 프로젝트는 후원을 취소할 수 없습니다.");
		}

		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		supportService.removeSupport(userSession.getAccount().getUsername(), pjId);
		
		List<Support> supports = supportService.getSupportsByUsername(userSession.getAccount().getUsername());
		return new ModelAndView("mySupports", "supports", supports);
	}
}
