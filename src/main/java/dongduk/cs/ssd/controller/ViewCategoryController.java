package dongduk.cs.ssd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.model.Category;
import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.CategoryServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class ViewCategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ProjectServiceImpl projectService;
	
	@ModelAttribute("categoryList")
	public List<Category> getCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		return categoryList;
	}
	
	@RequestMapping("/categoryList")
	public String categoryList() {
		return "categoryList";
	}
	
	@RequestMapping("/projects")	// 카테고리 별 프로젝트
	public String projectsByCategory(@RequestParam("category") String category, Model model) {
		List<Project> projects = projectService.getProjectsByCategory(category);
		model.addAttribute("projects", projects);
		model.addAttribute("category", category);
		return "projects";
	}
	
}
