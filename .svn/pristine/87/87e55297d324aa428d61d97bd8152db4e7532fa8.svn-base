package com.system.login;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/login")
@Scope("prototype")
public class loginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(){ 
		if(isLogin()){
		  return "main";
		}
		return "login";
	}
	
	@RequestMapping(value="/test")
	public String test(){
		return "main";
	}
	
	@RequestMapping(value="/dologin" )
	public String dologin(Model model,ServletRequest request,PrintWriter pw){
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("passWord");
		User user = new User();
		user.setUsercode(userCode);
		user.setPassword(password);
		String info = loginUser(user);
		if(info.equals("SUCCESS")){
			return "main";
		}else
			return "login";
	}
	
	private String loginUser(User user) {
		if(isLogin()) return "SUCCESS";
		return shiroLogin(user);
	}

	private String shiroLogin(User user) {
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsercode(),user.getPassword());
	    token.setRememberMe(true);
	    try{
	      SecurityUtils.getSubject().login(token);
	    }catch (UnknownAccountException ex) {
			return "用户不存在或者密码错误！";
		} catch (IncorrectCredentialsException ex) {
			return "用户不存在或者密码错误！";
		} catch (AuthenticationException ex) {
			return ex.getMessage(); // 自定义报错信息
		} catch (Exception ex) {
			ex.printStackTrace();
			return "内部错误，请重试！";
		}
		return "SUCCESS";
	}

	private boolean isLogin() {
		Subject su = SecurityUtils.getSubject();
		if(su.isAuthenticated()){
			return true;
		}
		return false;
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
