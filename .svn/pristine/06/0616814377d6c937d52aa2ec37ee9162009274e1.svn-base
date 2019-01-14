package com.base.util;

public class DBModel {
	private String columnName;
	private String dataType;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getColumnNameSql(){
		return sqlUtil.unlineToCase(columnName);
	}
	public String getGMethod(){
		return sqlUtil.getGMethod(getColumnNameSql());
	}
	
}
