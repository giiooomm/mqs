package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.thoughtworks.xstream.XStream;
import com.wechat.model.MessageAns;
import com.wechat.util.MessageUtil;
import com.wechat.util.SignUtil;

@RequestMapping("/wechat")
@Controller
public class WechatController {
	private static Logger logger = Logger.getLogger(WechatController.class);
 
 
	@RequestMapping(value = "/wx.do",method=RequestMethod.GET)
	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		logger.error("WechatController   ----   WechatController");
 
		System.out.println("========WechatController========= ");
		logger.info("请求进来了...");
 
		Enumeration<?> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			// out.print(name + "=" + value);
 
			String log = "name =" + name + "     value =" + value;
			logger.error(log);
		}
 
		String signature = request.getParameter("signature");/// 微信加密签名
		String timestamp = request.getParameter("timestamp");/// 时间戳
		String nonce = request.getParameter("nonce"); /// 随机数
		String echostr = request.getParameter("echostr"); // 随机字符串
		PrintWriter out = response.getWriter();
 
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
			System.out.println(echostr+"==========================");
		}
		out.close();
		out = null;
 
	}
	@RequestMapping(value = "/wx.do",method=RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map = null;
		try {
			map = MessageUtil.parseXml(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(String key : map.keySet()){
        	System.out.println(key+":"+map.get(key));
        }
        MessageAns message = new MessageAns();
        message.setToUserName(map.get("FromUserName"));
        message.setFromUserName(map.get("ToUserName"));
        message.setContent("我收到了你的消息!");
        message.setMsgType("text");
        message.setCreateTime((Long.parseLong(map.get("CreateTime"))));
        XStream xs = MessageUtil.getXstream();
        xs.alias("xml", MessageAns.class);
        String result = xs.toXML(message);
        System.out.println(result);
        response.getWriter().print(result);
        
}
 
}
