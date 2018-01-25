package com.xc.systemmanage_core.model;
import java.io.Serializable;
    /*
     *市行政政区划表
     *
     */
public class BaseCity implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *市唯一标示
     *
     */
    private Integer id;
    /**
     *市行政编码
     *
     */
    private String cityID;
    /**
     *市名称
     *
     */
    private String city;
    /**
     *上级单位行政编码
     *
     */
    private String father;

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer ids){
        this.id = ids;
    }

    public String getCityID(){
        return cityID;
    }
    
    public void setCityID(String cityIDs){
        this.cityID = cityIDs;
    }

    public String getCity(){
        return city;
    }
    
    public void setCity(String citys){
        this.city = citys;
    }

    public String getFather(){
        return father;
    }
    
    public void setFather(String fathers){
        this.father = fathers;
    }
    public BaseCity(){
     	super();
	}
	@Override
	public String toString() {
		return "BaseCity ["+""
		 + "id="+id+","
		 + "cityID="+cityID+","
		 + "city="+city+","
		 + "father="+father+","
		  + "]";
	}
}