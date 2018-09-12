package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogDao;
import com.blog.model.Blog;
@Service
public class BlogService {
    @Autowired
	private BlogDao blogDao;
    
	public int save(Blog blog) {
	  return blogDao.save(blog);
	}

	public List<Blog> qryBlogList(Blog blog) {
		return blogDao.qryBlogList(blog);
		
	}

	public Blog qryBlogById(Long id) {
		return blogDao.qryBlogById(id);		
	}

	public int updateBlogById(Blog blog) {
		return blogDao.updateBlogById(blog);		
	}

	public int delBlogById(Long id) {	
		return blogDao.delBlogById(id);
	}

}
