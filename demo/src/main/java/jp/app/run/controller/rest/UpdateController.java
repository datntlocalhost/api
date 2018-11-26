package jp.app.run.controller.rest;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.app.run.business.ClassFactory;
import jp.app.run.model.ClassModel;
import jp.app.run.util.JsonUtils;

@RestController
public class UpdateController {

	@GetMapping(value = "/update")
	public String update(Model model) {
		
		ClassFactory.getInstance().updateClassFactory();
		
		ArrayList<ClassModel> classList = ClassFactory.getInstance().getClassInfoList();
		
		model.addAttribute("classList", classList);
		
		return JsonUtils.ObjectToJson(true);
	}
}
