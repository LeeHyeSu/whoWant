package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.service.ProjectServiceImpl;
import dongduk.cs.ssd.service.SupportServiceImpl;

@Controller
public class RemoveProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private SupportServiceImpl supportService;

	@RequestMapping("/removeProject")
	public ModelAndView removeProject(HttpServletRequest request, Model model) { // 프로젝트 삭제
		int pjId = Integer.parseInt(request.getParameter("projectId"));

		if (!supportService.getSupportsByProject(pjId).isEmpty()) {	
			return new ModelAndView("error", "message", "이미 후원받은 프로젝트는 삭제할 수 없습니다.");
		}
		projectService.removeProject(pjId);
		return new ModelAndView("projectDone", "result", "삭제");
	}
}
