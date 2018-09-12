package com.user.controller;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 商品分类标签Controller
 * @author Xiexiaomei
 *
 */
@Controller
@RequestMapping(value = "/mall/goodCategory")
public class GdGoodCategoryController{


	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("======");
		System.out.println("======");
		return "mall/goodCategory";
	}
	@RequestMapping(value="toDesign",method=RequestMethod.GET)
	public String toDesign(Model model,ServletRequest request){
		String winName = request.getParameter("winName");
		model.addAttribute("winName", winName);
		return "mall/customMade_design";
	}


}
