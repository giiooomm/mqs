package com.system;

import java.util.List;

import javax.servlet.ServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.util.JsonUtil;
import com.system.model.Menu;
import com.system.service.SystemService;

@Controller
@RequestMapping("sys")
@Scope("prototype")
public class SystemController {
	
  @Autowired
  private SystemService systemService;
  @RequestMapping(value="menu",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String menu(ServletRequest request,Model model){
	List<Menu> list = systemService.qryMenuList();
	System.out.println(list.get(0));
	JSONArray jsonArray= JsonUtil.modelToJsonArray(list);
	System.out.println(jsonArray.toString());
	return jsonArray.toString();
  }
}
