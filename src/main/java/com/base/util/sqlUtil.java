package com.base.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;



public class sqlUtil {

	public static void main(String[] args) {
		
		DBModel model = new DBModel();
		model.setColumnName("cust_id");
		model.setDataType("int");
		DBModel model2 = new DBModel();
		model2.setColumnName("custName");
		model2.setDataType("varchar");
		List<DBModel> list = new ArrayList<DBModel>();
		list.add(model);
		list.add(model2);
		List<DBModel> list2 = new ArrayList<DBModel>();
		list2.addAll(list);
		list.remove(0);
		for(DBModel models : list2){
			System.out.println(models.getColumnName());
		}
		
		
	}
	
	public static String unlineToCase(String name){
		String[] nameArray = name.split("_");
		if(nameArray.length > 0){
			for(int i=1;i<nameArray.length;i++){
				String temp = nameArray[i].substring(0,1);
				String caseTemp = temp.toUpperCase();
				nameArray[i] = nameArray[i].replaceFirst(temp, caseTemp);
			}
		}
		return 	StringUtils.join(nameArray);
	}
	
	public static String getGMethod(String name){
		String temp = name.substring(0,1);
		String caseChar = temp.toUpperCase();
		return "get"+name.replaceFirst(temp, caseChar)+"()";
	}
	
	public static String getSelectSql(List<DBModel> models){
		StringBuffer sql = new StringBuffer(1024);
		StringBuffer where = new StringBuffer(1024);
		String modelName = "model";
		sql.append("sql.append(\"select ");
		where.append("sql.append(\" from \").append().append(\" where 1=1 \");\n");
		for(DBModel model : models){
			String modelMethodName = "";
			sql.append(model.getColumnName());
			if(model.getDataType().indexOf("int") >= 0){
			    modelMethodName = modelName+"."+model.getGMethod();
				where.append("if(").append(modelMethodName).append("!=null && ").append(modelMethodName).append(".intValue() > 0)\n");
				where.append("  sql.append(\"").append(model.getColumnName()).append("=").append(modelMethodName).append("\");\n");
				
			}else if(model.getDataType().indexOf("varchar") >= 0){
				 modelMethodName = modelName+"."+model.getGMethod();
					where.append("if(StringUtils.isNotBlank(").append(modelMethodName).append(")\n");
					where.append("  sql.append(\" and ").append(model.getColumnName()).append("=\").append(").append(modelMethodName).append(");\n");
			}else if(model.getDataType().indexOf("time") >= 0){
				
			}
		}
		sql.append(" \")");
		return sql.toString()+";\n"+where.toString();
	}
}
