package com.xc.systemmanage_core.model;
import java.io.Serializable;
import java.sql.Timestamp;
    /*
     *附件表
     *
     */
public class Attachment implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *附件标示
     *
     */
    private String attachUuid;
    /**
     *附件系统名称
     *
     */
    private String attachSysName;
    /**
     *附件原名称
     *
     */
    private String attachRealName;
    /**
     *附件类型
     *
     */
    private Integer attachType;
    /**
     *附件系统路径
     *
     */
    private String attachSysPath;
    /**
     *附件原上传路径
     *
     */
    private String attachUpPath;
    /**
     *附件大小
     *
     */
    private double attachSize;
    /**
     *附件后缀
     *
     */
    private String attachEtc;
    /**
     *附件上传时间
     *
     */
    private Timestamp attachUpTime;
    /**
     *附件上传人标示
     *
     */
    private String attachUpPerson;
    /**
     *备注
     *
     */
    private String attachMemo;
    /**
     *附件最后修改时间
     *
     */
    private Timestamp attachModifyTime;

    public String getAttachUuid(){
        return attachUuid;
    }
    
    public void setAttachUuid(String attachUuids){
        this.attachUuid = attachUuids;
    }

    public String getAttachSysName(){
        return attachSysName;
    }
    
    public void setAttachSysName(String attachSysNames){
        this.attachSysName = attachSysNames;
    }

    public String getAttachRealName(){
        return attachRealName;
    }
    
    public void setAttachRealName(String attachRealNames){
        this.attachRealName = attachRealNames;
    }

    public Integer getAttachType(){
        return attachType;
    }
    
    public void setAttachType(Integer attachTypes){
        this.attachType = attachTypes;
    }

    public String getAttachSysPath(){
        return attachSysPath;
    }
    
    public void setAttachSysPath(String attachSysPaths){
        this.attachSysPath = attachSysPaths;
    }

    public String getAttachUpPath(){
        return attachUpPath;
    }
    
    public void setAttachUpPath(String attachUpPaths){
        this.attachUpPath = attachUpPaths;
    }

    public double getAttachSize(){
        return attachSize;
    }
    
    public void setAttachSize(double attachSizes){
        this.attachSize = attachSizes;
    }

    public String getAttachEtc(){
        return attachEtc;
    }
    
    public void setAttachEtc(String attachEtcs){
        this.attachEtc = attachEtcs;
    }

    public Timestamp getAttachUpTime(){
        return attachUpTime;
    }
    
    public void setAttachUpTime(Timestamp attachUpTimes){
        this.attachUpTime = attachUpTimes;
    }

    public String getAttachUpPerson(){
        return attachUpPerson;
    }
    
    public void setAttachUpPerson(String attachUpPersons){
        this.attachUpPerson = attachUpPersons;
    }

    public String getAttachMemo(){
        return attachMemo;
    }
    
    public void setAttachMemo(String attachMemos){
        this.attachMemo = attachMemos;
    }

    public Timestamp getAttachModifyTime(){
        return attachModifyTime;
    }
    
    public void setAttachModifyTime(Timestamp attachModifyTimes){
        this.attachModifyTime = attachModifyTimes;
    }
    public Attachment(){
     	super();
	}
	@Override
	public String toString() {
		return "Attachment ["+""
		 + "attachUuid="+attachUuid+","
		 + "attachSysName="+attachSysName+","
		 + "attachRealName="+attachRealName+","
		 + "attachType="+attachType+","
		 + "attachSysPath="+attachSysPath+","
		 + "attachUpPath="+attachUpPath+","
		 + "attachSize="+attachSize+","
		 + "attachEtc="+attachEtc+","
		 + "attachUpTime="+attachUpTime+","
		 + "attachUpPerson="+attachUpPerson+","
		 + "attachMemo="+attachMemo+","
		 + "attachModifyTime="+attachModifyTime+","
		  + "]";
	}
}