package com.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.dao.SystemDao;
import com.system.model.Menu;
import com.system.util.MenuUtil;

@Service
public class SystemService {
	@Autowired
    private SystemDao systemDao;
	public List<Menu> qryMenuList() {
		List<Menu> list =  systemDao.qryMenuList();
		return MenuUtil.getMenulist(list);
	}

}
