package dongduk.cs.ssd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class IndexController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@RequestMapping("/index") // 메인페이지
	public String projectList(Model model) {
		List<Project> projects = projectService.getProjectList();	// 모든 프로젝트 리스트
		model.addAttribute("projects", projects);
		return "index";
	}
	
}
