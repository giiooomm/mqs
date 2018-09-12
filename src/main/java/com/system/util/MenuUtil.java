package com.system.util;

import java.util.ArrayList;
import java.util.List;
import com.system.model.Menu;

public class MenuUtil {
  public static List<Menu> getMenulist(List<Menu> list){
	  List<Menu> newlist = new ArrayList<Menu>();
	  for(Menu m : list){
		  Long parent = m.getMenuParent();
		  if(parent == 0){
			  for(Menu m2 : list){
				  if(m2.getMenuParent().equals(m.getMenuId())){
					  if(m.getChild() == null){
						m.setChild(new ArrayList<Menu>());
					  }
					  m.getChild().add(m2);
				  }
			  }
			  newlist.add(m);
		  }	  
	  }
	return newlist;  
  }
}
