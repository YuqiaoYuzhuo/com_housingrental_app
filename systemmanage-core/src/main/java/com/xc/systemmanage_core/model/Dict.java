package com.xc.systemmanage_core.model;
import java.io.Serializable;
import java.sql.Timestamp;
    /*
     *系统系统字典表
     *
     */
public class Dict implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *字典码标示
     *
     */
    private String dictUuid;
    /**
     *字典类型标示
     *
     */
    private String dcitTypeuuid;
    /**
     *字典码值
     *
     */
    private Integer dcitEnum;
    /**
     *字典码名称
     *
     */
    private String dictName;
    /**
     *字典码是否有效
     *
     */
    private Integer dictValid;
    /**
     *字典码排序
     *
     */
    private Integer dcitSort;
    /**
     *最后修改时间
     *
     */
    private Timestamp dcitLastModifyTime;

    public String getDictUuid(){
        return dictUuid;
    }
    
    public void setDictUuid(String dictUuids){
        this.dictUuid = dictUuids;
    }

    public String getDcitTypeuuid(){
        return dcitTypeuuid;
    }
    
    public void setDcitTypeuuid(String dcitTypeuuids){
        this.dcitTypeuuid = dcitTypeuuids;
    }

    public Integer getDcitEnum(){
        return dcitEnum;
    }
    
    public void setDcitEnum(Integer dcitEnums){
        this.dcitEnum = dcitEnums;
    }

    public String getDictName(){
        return dictName;
    }
    
    public void setDictName(String dictNames){
        this.dictName = dictNames;
    }

    public Integer getDictValid(){
        return dictValid;
    }
    
    public void setDictValid(Integer dictValids){
        this.dictValid = dictValids;
    }

    public Integer getDcitSort(){
        return dcitSort;
    }
    
    public void setDcitSort(Integer dcitSorts){
        this.dcitSort = dcitSorts;
    }

    public Timestamp getDcitLastModifyTime(){
        return dcitLastModifyTime;
    }
    
    public void setDcitLastModifyTime(Timestamp dcitLastModifyTimes){
        this.dcitLastModifyTime = dcitLastModifyTimes;
    }
    public Dict(){
     	super();
	}
	@Override
	public String toString() {
		return "Dict ["+""
		 + "dictUuid="+dictUuid+","
		 + "dcitTypeuuid="+dcitTypeuuid+","
		 + "dcitEnum="+dcitEnum+","
		 + "dictName="+dictName+","
		 + "dictValid="+dictValid+","
		 + "dcitSort="+dcitSort+","
		 + "dcitLastModifyTime="+dcitLastModifyTime+","
		  + "]";
	}
}