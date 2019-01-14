package com.wechat.model;

import com.system.util.DateUtil;


public class PostContext {
  private String ftime;
  private String time;
  private String context;
  private String location;

  private Long orderNum;
  public String getFtime() {
    return ftime;
  }
  public void setFtime(String ftime) {
    this.ftime = ftime;
  }
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public String getContext() {
    return context;
  }
  public void setContext(String context) {
    this.context = context;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public Long getOrderNum() {
    return new Long(
        DateUtil.convert2long(time, "yyyy-MM-dd HH:mm:ss"));
  }
  public void setOrderNum(Long orderNum) {
    this.orderNum = orderNum;
  }
  
}
