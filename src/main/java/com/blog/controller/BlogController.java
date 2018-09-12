package com.blog.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.util.DateUtil;
import com.base.util.JsonUtil;
import com.base.util.RequestUtil;
import com.blog.model.Blog;
import com.blog.service.BlogService;
@Controller
@RequestMapping("blog")
@Scope("prototype")
public class BlogController {
  @Autowired
  private BlogService blogService;	
	
  @RequestMapping(value="save",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")	
  @ResponseBody
  public String save(ServletRequest request,ServletResponse response){
	  Blog reblog = RequestUtil.getObject(Blog.class, request);
	  Enumeration<?> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			// out.print(name + "=" + value);
			@SuppressWarnings("unused")
			String log = "name =" + name + "     value =" + value;
		}
	  Blog blog = new Blog(null,reblog.getTitle(),reblog.getContent(),DateUtil.getCurrentDate(),"wuk");
	  int ret = blogService.save(blog);
	  if(ret > 0)
	  	return JsonUtil.getResultJson("添加成功！");
		  //return "更新成功";
	  else
	    return JsonUtil.getResultJson("添加失败！");
  }
  
  @RequestMapping(method=RequestMethod.GET)	
  public String toBlog(ServletRequest request,Model model){
	List<Blog> list = blogService.qryBlogList(new Blog()); 
	model.addAttribute("list", list);
	return "blog/blog";
  }
  
  @RequestMapping(value="toAdd",method=RequestMethod.GET)
  public String toAdd(ServletRequest request,Model model){
  	return "blog/blog_add";
  }
  
  @RequestMapping(value="toContent",method=RequestMethod.GET)
  public String toContent(ServletRequest request,Model model){
	  Long id = new Long(request.getParameter("id"));
	  Blog blog = blogService.qryBlogById(id);
	  model.addAttribute("blog", blog);
  	return "blog/blog_content";
  }
  
  @RequestMapping(value="toUpdate",method=RequestMethod.GET)
  public String toUpdate(ServletRequest request,Model model){
	  Long id = new Long(request.getParameter("id"));
	  Blog blog = blogService.qryBlogById(id);
	  model.addAttribute("blog", blog);
  	return "blog/blog_edit";
  }
  
  @RequestMapping(value="update",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String update(ServletRequest request,Model model){
	  Blog blog = RequestUtil.getObject(Blog.class, request);
	  int ret = blogService.updateBlogById(blog);
	  if(ret > 0)
  	   return JsonUtil.getResultJson("更新成功！");
	  else
	   return JsonUtil.getResultJson("更新失败！"); 
  }
  
  @RequestMapping(value="delete",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String delete(ServletRequest request,Model model){
	  Long id = new Long(request.getParameter("id"));
	  int ret = blogService.delBlogById(id);
	  if(ret > 0)
	  	 return JsonUtil.getResultJson("刪除成功！");
	  else
		  return JsonUtil.getResultJson("刪除失败！");
  }
}
