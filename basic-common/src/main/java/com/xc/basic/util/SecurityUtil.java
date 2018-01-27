package com.xc.basic.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Title:用户密码加密工具类 </p>
 * <p>Description:用户密码加密工具类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
public class SecurityUtil {
	/**
	 * <p>Description:只是用密码单重加密<p>
	 * @param password 密码
	 * @return 加密后的密码
	 * @throws NoSuchAlgorithmException
	 * @author wanglei 2018年1月27日
	 */
	public static String md5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	/**
	 * <p>Description:利用用户和密码双重加密<p>
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回加密后的密码
	 * @throws NoSuchAlgorithmException
	 * @author wanglei 2018年1月27日
	 */
	public static String md5(String username,String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(username.getBytes());
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
}
