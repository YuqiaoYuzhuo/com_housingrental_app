package com.xc.basic.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
@SuppressWarnings("rawtypes")
public class EnumUtils {
	
	/**
	 * <p>Description:枚举转换成序号list<p>
	 * @param clz
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public static List<Integer> enum2Ordianl(Class < ?extends Enum> clz){
		List<Integer> rels = null;
		if(!clz.isEnum()){
			return rels;
		}
		Enum [] enums = clz.getEnumConstants();
		rels = new ArrayList<Integer>();
		for(Enum enu :enums){
			rels.add(enu.ordinal());
		}
		return rels;
	}
	/**
	 * <p>Description:枚举的名字转换成list<p>
	 * @param clz
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public static List<String> enum2Name(Class < ?extends Enum> clz){
		List<String> rels = null;
		if(!clz.isEnum()){
			return rels;
		}
		Enum [] enums = clz.getEnumConstants();
		rels = new ArrayList<String>();
		for(Enum enu :enums){
			rels.add(enu.name());
		}
		return rels;
	}
	/**
	 * <p>Description:枚举转换成map<p>
	 * @param clz
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public static Map<Integer,String> enum2BasicMap(Class < ?extends Enum> clz){
		Map<Integer,String> rels = null;
		if(!clz.isEnum()){
			return rels;
		}
		Enum [] enums = clz.getEnumConstants();
		rels = new HashMap<Integer,String>();
		for(Enum enu :enums){
			rels.put(enu.ordinal(),enu.name());
		}
		return rels;
	}
	/**
	 * 将枚举中的值的某个属性转换为字符串列表
	 * @param clz
	 * @param propName某个属性值
	 * @return
	 */
	public static List<String> enumProp2List(Class<? extends Enum> clz,String propName) {
		if(!clz.isEnum()) return null;
		try {
			Enum[] enums = clz.getEnumConstants();
			List<String> rels = new ArrayList<String>();
			for(Enum en:enums) {
				rels.add((String)PropertyUtils.getProperty(en, propName));
			}
			return rels;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将枚举中的值的某个属性转换为序号和字符串列表
	 * @param clz
	 * @param propName某个属性值
	 * @return
	 */
	public static Map<Integer,String> enumProp2OrdinalMap(Class<? extends Enum> clz,String propName) {
		if(!clz.isEnum()) return null;
		try {
			Enum[] enums = clz.getEnumConstants();
			Map<Integer,String> rels = new HashMap<Integer,String>();
			for(Enum en:enums) {
				rels.put(en.ordinal(),(String)PropertyUtils.getProperty(en, propName));
			}
			return rels;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将枚举中的值的某个属性转换为名称和字符串map
	 * @param clz
	 * @param propName某个属性值
	 * @return
	 */
	public static Map<String,String> enumProp2NameMap(Class<? extends Enum> clz,String propName) {
		if(!clz.isEnum()) return null;
		try {
			Enum[] enums = clz.getEnumConstants();
			Map<String,String> rels = new HashMap<String,String>();
			for(Enum en:enums) {
				rels.put(en.name(),(String)PropertyUtils.getProperty(en, propName));
			}
			return rels;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将枚举中的两个属性转换为map
	 * @param clz
	 * @param keyProp 要转化的key的属性名称
	 * @param valueProp 要转换的value的属性名称
	 * @return
	 */
	public static Map<String,String> enumProp2Map(Class<? extends Enum> clz,String keyProp,String valueProp) {
		if(!clz.isEnum()) return null;
		try {
			Enum[] enums = clz.getEnumConstants();
			Map<String,String> rels = new HashMap<String,String>();
			for(Enum en:enums) {
				rels.put((String)PropertyUtils.getProperty(en,keyProp),(String)PropertyUtils.getProperty(en,valueProp));
			}
			return rels;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
