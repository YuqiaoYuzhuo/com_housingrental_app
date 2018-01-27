package com.xc.basic.util;

import java.util.UUID;

/**
 * <p>Title: 生成uuid的工具类</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
public class UUIDGenerator {   
    public UUIDGenerator() {   
    }   
  
    public static String createUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        // 去掉"-"符号   
        String temp = str.replace("-", "");
        return temp;   
    }   
    //获得指定数量的UUID   
    
    public static String[] createUUIDs(int number) {   
        if (number < 1) {   
            return null;   
        }   
        String[] ss = new String[number];   
        for (int i = 0; i < number; i++) {   
            ss[i] = createUUID();   
        }   
        return ss;   
    }   
  
    public static void main(String[] args) {   
        String[] ss = createUUIDs(10);   
        for (int i = 0; i < ss.length; i++) {   
            System.out.println("ss["+i+"]====="+ss[i]);   
        }   
    }   
}  
