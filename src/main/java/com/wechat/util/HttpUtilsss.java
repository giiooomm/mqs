package com.wechat.util;

import java.util.List;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;







import org.apache.commons.lang.StringUtils;

import com.base.util.JsonUtil;
import com.wechat.model.PostContext;
import com.wechat.model.PostTmpModel;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class HttpUtilsss<T>{
  public String load(String url,String query) throws Exception
  {
      URL restURL = new URL(url);
      /*
       * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
       */
      HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
      //请求方式
      conn.setRequestMethod("POST");
      //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
      conn.setDoOutput(true);
      //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
      conn.setAllowUserInteraction(false);

      PrintStream ps = new PrintStream(conn.getOutputStream());
      ps.print(query);

      ps.close();

      BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String line,resultStr="";

      while(null != (line=bReader.readLine()))
      {
      resultStr +=line;
      }
      //System.out.println(resultStr);
      bReader.close();

      return resultStr;

  }
   @SuppressWarnings({ "unused", "rawtypes" })
  public  List<T> orderList(List<T> oldList,String name,Boolean order) throws Exception{
     if(oldList == null || oldList.size() == 0 || !StringUtils.isNotBlank(name)) return null;
     Class clazz = oldList.get(0).getClass();
     System.out.println(clazz.getName());
     Field field = clazz.getDeclaredField(name);
     if(field.getType() != Long.class) return null;
     PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
     Method method = pd.getReadMethod();
     //Long[] lArray = new Long[oldList.size()];
     List<T> list = new ArrayList<T>();
     for(T t : oldList){
       Long orderNum = (Long) method.invoke(t);
       if(list.size() == 0){ list.add(t); continue;}
       for(int i=0;i<list.size();i++){
         T t2 = list.get(i);
         Long nowValue = (Long) method.invoke(t2);
         if(orderNum < nowValue){
           list.add(i, t);
           break;
         }else if(orderNum == nowValue){
           list.add(i+1, t);
           break;
         }else if(i != (list.size() - 1)){
           continue;
         }else{
           list.add(i+1, t);
           break;
         }
       }
     }
     
     
     return list;
  }
   
   
   public static String getMethodName(String name){
     return "get"+name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf(name.charAt(0)+32));
   }
   
   
   public static String getKuaidi(){
	   try {
		      @SuppressWarnings("rawtypes")
		      HttpUtilsss restUtil = new HttpUtilsss();
		      String resultString = restUtil.load("http://www.kuaidi100.com/query", "type=huitongkuaidi&postid=71230916928698"); 
		      JSONObject json = JSONObject.fromObject(resultString);
		      Map classMap = new HashMap();
		      classMap.put("data",PostContext.class);
		      PostTmpModel  model = (PostTmpModel) json.toBean(json, PostTmpModel.class,classMap);
		      //PostTmpModel  model =  JSONUtils. toEntity(PostTmpModel.class, resultString);
		      List<PostContext> list = (List<PostContext>)model.getData();
		      List<PostContext> list2 = restUtil.orderList(list,"orderNum",true);
		      String text = "";
		      for(PostContext context : list2){
		    	  text += context.getTime()+" "+context.getContext();
		    	  
		      }
		      return text;
		    }
		    catch (Exception e) {
		      System.out.print(e.getMessage());
		      return null;
		    }
   }
  @SuppressWarnings({"unchecked", "static-access" })
  public static void main(String[] args) {
    try {
      @SuppressWarnings("rawtypes")
      HttpUtilsss restUtil = new HttpUtilsss();
      String resultString = restUtil.load("http://www.kuaidi100.com/query", "type=huitongkuaidi&postid=71230916928698"); 
      JSONObject json = JSONObject.fromObject(resultString);
      Map classMap = new HashMap();
      classMap.put("data",PostContext.class);
      PostTmpModel  model = (PostTmpModel) json.toBean(json, PostTmpModel.class,classMap);
      //PostTmpModel  model =  JSONUtils. toEntity(PostTmpModel.class, resultString);
      List<PostContext> list = (List<PostContext>)model.getData();
      List<PostContext> list2 = restUtil.orderList(list,"orderNum",true);
      String text = "";
      for(PostContext context : list2){
    	  text += context.getTime()+" "+context.getContext();
      }
      
    }
    catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }
}
