package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.sapient.entity.User;
import com.sapient.manager.UserManager;

@Controller
@SessionAttributes("UserName")
public class LoginController {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private UserManager userService;
	public LoginController() {
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String getUser(Model model) {
		if(model.containsAttribute("UserName")){
			return "redirect:/";
		}
		User user = new User();
		model.addAttribute("User", user);
		return "Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute("User") User user, Model model) {
		if(model.containsAttribute("UserName")){
			return "redirect:/";
		}
		if (user.getUserName().equals("") || user.getPassword().equals("")) {
			String errMsg = "Sorry Login Unsuccessful  ";
			model.addAttribute("errMsg", errMsg);
			return "Login";
		}
		if (userService.validateUser(user)) {
			model.addAttribute("UserName", user.getUserName());
			return "welcome";
		} else {
			String errMsg = "Sorry Login Unsuccessful  ";
			model.addAttribute("errMsg", errMsg);
			return "Login";
		}

	}

	@RequestMapping("ForgotPassword")
	public String ForgotPassword(Model model) {
		return "ForgotPassword";
	}

}
