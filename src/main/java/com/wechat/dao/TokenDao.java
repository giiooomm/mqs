package com.wechat.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.base.util.EntitytoString;
import com.base.util.JDBCUtil;
@Repository
public class TokenDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int updateToken(String token){
		StringBuffer sql = new StringBuffer();
		sql.append("update wx_token set token = ").append(token);
		return jdbcTemplate.update(sql.toString());
	}
	
	public String getToken(){
		StringBuffer sql = new StringBuffer();
		sql.append("select token from  wx_token ");
		Map<String, Object> map = jdbcTemplate.queryForMap(sql.toString());
		return EntitytoString.getEntitys(map, String.class);
	}
}
