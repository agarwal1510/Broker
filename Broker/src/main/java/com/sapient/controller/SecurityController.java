
package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sapient.entity.SecurityEntity;
import com.sapient.manager.SecurityManager;

@Controller
@SessionAttributes("UserName")
public class SecurityController {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private SecurityManager securityManager;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Kodak Securities Limited");
		return "welcome";
	}

	@RequestMapping(value = "ConfigureSecurities", method = RequestMethod.GET)
	public String getSecurity(Model model) {
		if(!model.containsAttribute("UserName")){
			model.addAttribute("notLoggedIn", "You need to login to Configure Securities");
			return "ConfigureSecurities";}
		SecurityEntity securityEntity = new SecurityEntity();
		model.addAttribute("newSecurity", securityEntity);
		return "ConfigureSecurities";
	}

	@RequestMapping(value = "ConfigureSecurities", method = RequestMethod.POST)
	public String addSecurity(
			@ModelAttribute("newSecurity") SecurityEntity securityEntity,
			final Model model) {
		if(!model.containsAttribute("UserName"))
			return "redirect:Login";
		try {
			securityEntity.setSymbol(securityEntity.getSymbol().toUpperCase());
			securityManager.setSecurity(securityEntity);
			String successMsg="Added " + securityEntity.getName()
					+ "(" + securityEntity.getSymbol() + ")"
					+ " successfully to the System.";
			model.addAttribute("successMsg", successMsg);
			System.out.println(successMsg);
		} catch (Exception e) {
			String errMsg="Error while adding securities. Try again.";
			model.addAttribute("successMsg", errMsg);
			//System.out.println(e.getMessage());
		}
		return getSecurity(model);		
	}

	@RequestMapping("/ViewSecurities")
	public String list(Model model) {
		List<SecurityEntity> securityList = new ArrayList<>();
		securityList = securityManager.getSecurityList();
		model.addAttribute("securityList", securityList);

		return "ViewSecurities";
	}
}
