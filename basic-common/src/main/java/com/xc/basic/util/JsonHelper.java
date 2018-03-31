package com.xc.basic.util;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;


/**
 * 
 * 1:将JavaBean转换成Map、JSONObject
 * 2:将Map转换成Javabean
 * 3:将JSONObject转换成Map、Javabean
 * 
 * @author Alexia
 */

public class JsonHelper {
    
    /**
     * 将Javabean转换为Map
     * 
     * @param javaBean
     *            javaBean
     * @return Map对象
     */
    @SuppressWarnings({ "rawtypes" })
	public static Map toMap(Object javaBean) {
        return ReflectUtils.getBeanProperty(javaBean);

    }

    /**
     * 将Json对象转换成Map
     * 
     * @param jsonObject
     *            json对象
     * @return Map对象
     * @throws JSONException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map toMap(String jsonString) throws JSONException {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {

            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);

        }
        return result;

    }

    /**
     * 将JavaBean转换成JSONObject（通过Map中转）
     * 
     * @param bean
     *            javaBean
     * @return json对象
     */
    public static JSONObject toJSON(Object bean) {

        return JSONObject.fromObject(toMap(bean));

    }
    /**
     * <p>Description:将map转换成json<p>
     * @param map map
     * @return
     * @author wanglei 2017年12月31日
     */
    @SuppressWarnings("rawtypes")
	public static JSONObject mapToJSON(Map map) {

        return JSONObject.fromObject(map);

    }

    /**
     * 将Map转换成Javabean
     * 
     * @param javabean
     *            javaBean
     * @param data
     *            Map数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object toJavaBean(Object javabean, Map data) {
        return ReflectUtils.setBeanProperty(data, javabean.getClass());
    }

    /**
     * JSONObject到JavaBean
     * 
     * @param bean
     *            javaBean
     * @return json对象
     * @throws ParseException
     *             json解析异常
     * @throws JSONException
     */
    @SuppressWarnings("rawtypes")
	public static void toJavaBean(Object javabean, String jsonString)
            throws ParseException, JSONException {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map map = toMap(jsonObject.toString());
        
        toJavaBean(javabean, map);
    }

}
