package com.user.controller;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.Service.UserService;
import com.user.model.User;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(){
		System.out.println("=======来来==========");
		System.out.println("=========来来========");
		System.out.println("=========来来========");
		System.out.println("========来来=========");
		return "login";
	}
	
	@RequestMapping(value="/test")
	public String test(){
		System.out.println("========来不来=========");
		return "test";
	}
	
	@RequestMapping(value="/dologin" )
	public void dologin(Model model,ServletRequest request,PrintWriter pw){
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("passWord");
		System.out.println(userCode + password);
		User user = userService.getUser(userCode,password);
		if(user != null){
			pw.write("login success!");
		}else{
			pw.write("login false!");
		}
	}
	
	@RequestMapping(value="/register")
	public String regiter(){
		return "table";
	}
	@RequestMapping(value="/doregister", method=RequestMethod.GET)
	public void doregister(ServletRequest request,PrintWriter pw){
		String userCode = request.getParameter("username");
		String password = request.getParameter("password");
		userService.insertTo(userCode,password);
		pw.write("insert success!");
	}
	
	@RequestMapping(value="/verifyCode")
	@ResponseBody
	public String verifyCode(ServletRequest request){
		JSONObject json = new JSONObject();
		String userCode = request.getParameter("username");
		if(userService.verfiCode(userCode)){
			json.put("verifyResult","true");
		}else{
			json.put("verifyResult","false");
		}
		System.out.println(json.toString());
		return json.toString();
	}
}
