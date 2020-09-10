package dongduk.cs.ssd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.AccountServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class RemoveAccountController {
	
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private ProjectServiceImpl projectService;

	@RequestMapping("/withdraw")
	public ModelAndView withdraw(HttpServletRequest request, HttpSession session, Model model) { // 회원 탈퇴하기 
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		List<Project> projects = projectService.getProjectsByUsername(userSession.getAccount().getUsername());
		if (!projects.isEmpty()) {	
			for(Project project : projects) {
				if(project.getState().equalsIgnoreCase("ONGOING")) {
					return new ModelAndView("error","message", "진행중인 프로젝트가 있어 탈퇴할 수 없습니다.");
				}
			}
		}
		
		accountService.removeAccount(userSession.getAccount().getUsername());
		session.removeAttribute("userSession");
		session.invalidate();
		return new ModelAndView("redirect:http://localhost:8080/whoWant/index");
	}
}
