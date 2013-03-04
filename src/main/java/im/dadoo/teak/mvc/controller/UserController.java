package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.User;
import im.dadoo.teak.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/admin/user/{userId}/update", method = RequestMethod.POST)
	public String update(@PathVariable int userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
		User user = this.us.fetchById(userId);
		if (user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			this.us.update(user);
			return "redirect:/admin";
		}
		else {
			return "redirect:/admin/user/" + userId + "/update";
		}
	}
}
