package com.wechat.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.util.RedisCacheManager;
import com.wechat.dao.TokenDao;
import com.wechat.util.TokenUtil;

@Service
public class TokenService {
	@Autowired
	private TokenDao tokenDao;
	@Resource
	private RedisCacheManager redisCacheManager;
	public String updateToken(){
		String token = "";
		while(StringUtils.isNotBlank(token)){
		  try {
			token = TokenUtil.getToken();
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}
		int ret = tokenDao.updateToken(token);
		if(ret > 0){
			redisCacheManager.set("WX_ACCESS_TOKEN", token);	
		}
		
		return null;
	}
}
