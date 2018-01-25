package com.xc.systemmanage_core.model;
import java.io.Serializable;
import java.sql.Timestamp;
    /*
     *系统字典类型表
     *
     */
public class DictType implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *字典类型标示
     *
     */
    private String dcitTypeuuid;
    /**
     *字典码值
     *
     */
    private Integer dcitTypeEnum;
    /**
     *字典类型码名称
     *
     */
    private String dictTypeName;
    /**
     *字典类型是否有效
     *
     */
    private Integer dictTypeValid;
    /**
     *字典类型排序
     *
     */
    private Integer dcitTypeSort;
    /**
     *最后修改时间
     *
     */
    private Timestamp dcitTypeLastModifyTime;

    public String getDcitTypeuuid(){
        return dcitTypeuuid;
    }
    
    public void setDcitTypeuuid(String dcitTypeuuids){
        this.dcitTypeuuid = dcitTypeuuids;
    }

    public Integer getDcitTypeEnum(){
        return dcitTypeEnum;
    }
    
    public void setDcitTypeEnum(Integer dcitTypeEnums){
        this.dcitTypeEnum = dcitTypeEnums;
    }

    public String getDictTypeName(){
        return dictTypeName;
    }
    
    public void setDictTypeName(String dictTypeNames){
        this.dictTypeName = dictTypeNames;
    }

    public Integer getDictTypeValid(){
        return dictTypeValid;
    }
    
    public void setDictTypeValid(Integer dictTypeValids){
        this.dictTypeValid = dictTypeValids;
    }

    public Integer getDcitTypeSort(){
        return dcitTypeSort;
    }
    
    public void setDcitTypeSort(Integer dcitTypeSorts){
        this.dcitTypeSort = dcitTypeSorts;
    }

    public Timestamp getDcitTypeLastModifyTime(){
        return dcitTypeLastModifyTime;
    }
    
    public void setDcitTypeLastModifyTime(Timestamp dcitTypeLastModifyTimes){
        this.dcitTypeLastModifyTime = dcitTypeLastModifyTimes;
    }
    public DictType(){
     	super();
	}
	@Override
	public String toString() {
		return "DictType ["+""
		 + "dcitTypeuuid="+dcitTypeuuid+","
		 + "dcitTypeEnum="+dcitTypeEnum+","
		 + "dictTypeName="+dictTypeName+","
		 + "dictTypeValid="+dictTypeValid+","
		 + "dcitTypeSort="+dcitTypeSort+","
		 + "dcitTypeLastModifyTime="+dcitTypeLastModifyTime+","
		  + "]";
	}
}