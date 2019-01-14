package com.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.base.util.EntitytoString;
import com.system.model.Menu;

@Repository
public class SystemDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Menu> qryMenuList() {
		StringBuffer sql = new StringBuffer(64);
		sql.append("select menu_id,menu_name,menu_position,menu_url,menu_parent from ")
		.append("sys_menu ");
		sql.append("order by (case when menu_parent=0 then 0 else 1 end),menu_position");
		List<Map<String,Object>> maplist = jdbcTemplate.queryForList(sql.toString());
		@SuppressWarnings("unchecked")
		List<Menu> list = EntitytoString.getEntitys(maplist, Menu.class);
		 return list;
	}
}
