package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.model.Account;
import dongduk.cs.ssd.service.AccountServiceImpl;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/login")
public class LoginController {
	private final String LOGIN_FORM = "login";
	private String referer;
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@GetMapping
	public String form(HttpServletRequest request) {
		referer = request.getHeader("Referer");
		return LOGIN_FORM;
	}
	
	@PostMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		Account account = accountService.getAccount(username, password);
		if (account == null) {
			return new ModelAndView(LOGIN_FORM, "message", 
					"아이디 / 이메일 또는 비밀번호가 잘못되었습니다.");
		}
		else {
			UserSession userSession = new UserSession(account);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) {
				return new ModelAndView("redirect:" + forwardAction);
			}
			else {
				// 로그인 후 원래 페이지로 되돌아가기 	
				return new ModelAndView("redirect:" + referer);
			}
		}
	}

}
