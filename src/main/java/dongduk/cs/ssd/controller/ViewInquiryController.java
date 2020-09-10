package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dongduk.cs.ssd.model.Answer;
import dongduk.cs.ssd.model.Inquiry;
import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.AnswerServiceImpl;
import dongduk.cs.ssd.service.InquiryServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
public class ViewInquiryController {
	
	@Autowired
	private InquiryServiceImpl inquiryService;
	@Autowired
	private AnswerServiceImpl answerService;
	@Autowired
	private ProjectServiceImpl projectService;
	
	@RequestMapping("/viewInquiry") // 문의글 조회
	public String handleRequest(HttpServletRequest request, 
			@RequestParam("inquiryId") String inquiryId, Model model) {
		Inquiry inq = inquiryService.getInquiry(Integer.parseInt(inquiryId));
		model.addAttribute("inquiry", inq);
		
		Project pj = projectService.getProject(inq.getProjectId());
		model.addAttribute("project", pj);
		
		if(inq.getIsAnswer().equals("1")) {	
			Answer ans = answerService.getAnswer(Integer.parseInt(inquiryId));
			model.addAttribute("answer", ans);
		}
		
		return "viewInquiry";
	}
	
}
