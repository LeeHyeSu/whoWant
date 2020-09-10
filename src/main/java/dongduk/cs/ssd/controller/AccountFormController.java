package dongduk.cs.ssd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Account;
import dongduk.cs.ssd.service.AccountServiceImpl;

@Controller
@RequestMapping({"/newAccount", "/editAccount"})
@SessionAttributes("accountForm")
public class AccountFormController {

	private static final String formViewName = "accountForm";
																																							
	@Autowired
	private AccountServiceImpl accountService;
	
	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {	// edit an existing user
			Account a = accountService.getAccount(userSession.getAccount().getUsername());
			return new AccountForm(a.getUsername(), a.getName(), a.getPassword(), a.getPhonenum(), 
					a.getPostcode(), a.getAddress(), a.getDetailAddress(), a.getIntro());
		}
		else {	// create a new user
			return new AccountForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpSession session, 
			@Valid @ModelAttribute("accountForm") AccountForm accountForm, 
			BindingResult result, SessionStatus sessionStatus) {

		if (result.hasErrors()) return formViewName;
		accountForm.setAccount(new Account(accountForm));
		try {
			if (accountForm.isNewAccount()) {
				accountService.insertAccount(accountForm.getAccount());
			}
			else {
				accountService.updateAccount(accountForm.getAccount());
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("username", "USER_ID_ALREADY_EXISTS",
					"이미 존재하는 ID입니다.");
			 return formViewName;
		}
		
		UserSession userSession = new UserSession(
				accountService.getAccount(accountForm.getAccount().getUsername()));
		session.setAttribute("userSession", userSession);
		sessionStatus.setComplete();
		
		return "redirect:http://localhost:8080/whoWant/index";  
	}
	
}
