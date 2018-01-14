package com.xc.basic.util;


public class StringUtils {
	public static boolean isNll(String str){
		if(str==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotNull(String str){
		if(str!=null&&!"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	 public static boolean isEmpty(String str){
		 if(str.trim().length()<1){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 public static boolean isNotEmpty(String str){
		 if(str.trim().length()>=1){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 public static String gennerateLike(String str){
		 if(StringUtils.isNotNull(str)){
			 str.trim(); 
		 }
		 return "%"+str+"%";
	 }
}
