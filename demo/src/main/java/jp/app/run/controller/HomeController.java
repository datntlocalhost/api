package jp.app.run.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.app.run.business.ClassFactory;
import jp.app.run.model.ClassModel;

@Controller
public class HomeController {
	
	/*
	 * Load main page.
	 * 
	 * @param model
	 * @return index page
	 */
	@RequestMapping(value = {"/", "/index", "/home"})
	public String doGet(Model model) {
		
		ArrayList<ClassModel> classList = ClassFactory.getInstance().getClassInfoList();
		
		model.addAttribute("classList", classList);
		
		return "index";
	}

}
