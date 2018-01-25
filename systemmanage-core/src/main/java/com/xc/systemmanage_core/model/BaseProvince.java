package com.xc.systemmanage_core.model;
import java.io.Serializable;
    /*
     *省行政区划表
     *
     */
public class BaseProvince implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *省唯一标示
     *
     */
    private Integer id;
    /**
     *省行政编码
     *
     */
    private String provinceID;
    /**
     *上级单位行政编码
     *
     */
    private String province;

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer ids){
        this.id = ids;
    }

    public String getProvinceID(){
        return provinceID;
    }
    
    public void setProvinceID(String provinceIDs){
        this.provinceID = provinceIDs;
    }

    public String getProvince(){
        return province;
    }
    
    public void setProvince(String provinces){
        this.province = provinces;
    }
    public BaseProvince(){
     	super();
	}
	@Override
	public String toString() {
		return "BaseProvince ["+""
		 + "id="+id+","
		 + "provinceID="+provinceID+","
		 + "province="+province+","
		  + "]";
	}
}