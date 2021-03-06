package com.blog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.base.util.EntitytoString;
import com.base.util.JDBCUtil;
import com.blog.model.Blog;

@Repository
public class BlogDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(Blog blog) {
		StringBuffer sql = new StringBuffer(64);
		sql.append("insert into blog_theme(id,title,content,create_time,author) values(?,?,?,?,?)");
		Object[] obj = JDBCUtil.modelToObject(blog, Blog.class);
		
		return jdbcTemplate.update(sql.toString(),obj);
		
	}
    
	public List<Blog> qryBlogList(Blog blog) {
		StringBuffer sql = new StringBuffer(64);
		sql.append("select id,title,content,create_time,author from blog_theme");
		List<Map<String, Object>> list= jdbcTemplate.queryForList(sql.toString());
		if(list.size() >0){
			@SuppressWarnings("unchecked")
			List<Blog> blogList = EntitytoString.getEntitys(list, Blog.class);
			return blogList;
		}else{
			return null;
		}
		
	}

	public Blog qryBlogById(Long id) {
		StringBuffer sql = new StringBuffer(64);
		sql.append("select id,title,content,create_time,author from blog_theme ");
		sql.append(" where id = ").append(id);
		List<Map<String, Object>> list= jdbcTemplate.queryForList(sql.toString());
		if(list.size() >0){
			@SuppressWarnings("unchecked")
			List<Blog> blogList = EntitytoString.getEntitys(list, Blog.class);
			return blogList.get(0);
		}else{
			return null;
		}
	}

	public int updateBlogById(Blog blog) {
		StringBuffer sql = new StringBuffer(64);
		sql.append("update blog_theme set title = '").append(blog.getTitle())
		.append("' ,content='").append(blog.getContent())
		.append("' where id=").append(blog.getId());
		return jdbcTemplate.update(sql.toString());
	}

	public int delBlogById(Long id) {
		StringBuffer sql = new StringBuffer(64);
		sql.append("delete from blog_theme where id = ").append(id);
		return jdbcTemplate.update(sql.toString());
	}
} 
