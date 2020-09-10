package dongduk.cs.ssd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Account;
import dongduk.cs.ssd.model.Inquiry;
import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.AccountServiceImpl;
import dongduk.cs.ssd.service.InquiryServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class ViewProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private InquiryServiceImpl inquiryService;
	
	@RequestMapping("/allProjects") // 모든 프로젝트 (마감된 프로젝트 포함) 
	public String allProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		
		model.addAttribute("keyword", "모든 프로젝트");
		return "projects";
	}
	
	@RequestMapping("/myProjects") // 내가 만든 프로젝트
	public String myProjects(HttpServletRequest request, Model model) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		List<Project> projects = projectService.getProjectsByUsername(userSession.getAccount().getUsername());
		model.addAttribute("projects", projects);
		return "myProjects";
	}
	
	@RequestMapping("/project/{projectId}")	// 프로젝트 상세 조회
	public String projectDetail(@PathVariable String projectId, Model model) { // 프로젝트 조회
		Project pj = projectService.getProject(Integer.parseInt(projectId));
		model.addAttribute("project", pj);
		
		Account ac = accountService.getAccount(pj.getUsername());
		model.addAttribute("creater", ac);
		
		List<Project> projects = projectService.getProjectsByUsername(pj.getUsername());
		model.addAttribute("projects", projects);
		
		List<Inquiry> inquiries = inquiryService.getInquiryByProject(Integer.parseInt(projectId));	// 프로젝트 문의글
		model.addAttribute("inquiries", inquiries);
		return "viewProject";
	}
	
}
