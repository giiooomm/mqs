package com.system;

public class mybatisSql {

	public static void main(String[] args) {
		String s1 = "op_id,login_name,op_name,password,org_id,org_name,phone_id,email,weixin,open_id,create_date,lock_type,lock_date,op_type,sts,sts_date,remark";
		String s2 = "opId,loginName,opName,password,orgId,orgName,phoneId,email,weixin,openId,createDate,lockType,lockDate,opType,sts,stsDate,remark";
		System.out.println(updateSql(s1,s2));
		

	}
	
	public static String insertSql(String s1,String s2){
		String[] arg2 = s2.split(",");
		String temp = "";
		String insertSql = "";
		for(int i = 0;i<arg2.length;i++){
			temp = "#{"+arg2[i]+"},";
			insertSql+=temp;
			
		}
		return insertSql;
	}
	
	public static String updateSql(String s1,String s2){
		String[] arg1 = s1.split(",");
		String[] arg2 = s2.split(",");
		String temp = "";
		String updateSql = "";
		for(int i = 0;i<arg2.length;i++){
			temp = arg1[i]+"= #{"+arg2[i]+"},";
			updateSql+=temp;
			
		}
		return updateSql;
	}
}
