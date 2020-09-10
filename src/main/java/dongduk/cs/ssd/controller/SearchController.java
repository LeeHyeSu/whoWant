package dongduk.cs.ssd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@RequestMapping("/search")	// 프로젝트 검색
	public String searchProjects(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			Model model) {
		if(keyword.equals("")) {
			return "projects";
		}
		model.addAttribute("keyword", keyword);
		
		List<Project> projects = projectService.searchProjects(keyword);
		model.addAttribute("projects", projects);
		return "projects";
	}
	
}
