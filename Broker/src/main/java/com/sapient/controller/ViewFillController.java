package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sapient.entity.Fill;
import com.sapient.manager.FillManager;

@Controller
@SessionAttributes("UserName")
public class ViewFillController {

	public ViewFillController() {
	
	}
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private  FillManager fillManager;
	
	@RequestMapping("/ViewFills")
public String viewFillList(@RequestParam(value="page",defaultValue="0",required=false) int page ,Model model){
		if(!model.containsAttribute("UserName")){
			model.addAttribute("notLoggedIn", "You need to login to view Fills");
			return "ViewFills";
		}
		final int limit=10;
		List<Fill> fillList = new ArrayList<>();
		fillList = fillManager.viewListOfFills(limit*page,limit);
		model.addAttribute("fillList", fillList);
		/*         pagination       */
		if(fillList.size()<limit)
			model.addAttribute("next", false);
		
		model.addAttribute("page",page+1);
		/*         pagination       */
		return "ViewFills";
		
	}
}
