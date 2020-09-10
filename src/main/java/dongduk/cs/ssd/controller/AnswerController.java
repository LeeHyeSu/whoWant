package dongduk.cs.ssd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Answer;
import dongduk.cs.ssd.service.AnswerServiceImpl;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerServiceImpl answerService;

	@RequestMapping("/answer")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("answer") String answer,
			@RequestParam("inquiryId") String inquiryId,
			Model model) throws Exception {
		String referer = request.getHeader("Referer");
		
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		Answer ans = new Answer();
		ans.setInquiryId(Integer.parseInt(inquiryId));
		ans.setAnswer(answer);
		ans.setAnsDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		ans.setUsername(userSession.getAccount().getUsername());
		
		answerService.insertAnswer(ans);
		
		return new ModelAndView("redirect:" + referer);
	}
	
}
