package com.xc.systemmanage_core.model;
import java.io.Serializable;
    /*
     *区县行政区划表
     *
     */
public class BaseArea implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *区唯一标示
     *
     */
    private Integer id;
    /**
     *区行政代码
     *
     */
    private String areaID;
    /**
     *区名称
     *
     */
    private String area;
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

    public String getAreaID(){
        return areaID;
    }
    
    public void setAreaID(String areaIDs){
        this.areaID = areaIDs;
    }

    public String getArea(){
        return area;
    }
    
    public void setArea(String areas){
        this.area = areas;
    }

    public String getFather(){
        return father;
    }
    
    public void setFather(String fathers){
        this.father = fathers;
    }
    public BaseArea(){
     	super();
	}
	@Override
	public String toString() {
		return "BaseArea ["+""
		 + "id="+id+","
		 + "areaID="+areaID+","
		 + "area="+area+","
		 + "father="+father+","
		  + "]";
	}
}