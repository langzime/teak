package im.dadoo.teak.mvc.controller;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.model.User;
import im.dadoo.teak.mvc.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
		System.out.println(password);
		User user = this.us.fetchByUsername(username);
		if (user.getPassword().equals(password)) {
			user.setSigninDateTime(System.currentTimeMillis());
			this.us.update(user);
			session.setAttribute("loginUser", user);
			return "redirect:/admin";
		}
		else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
}