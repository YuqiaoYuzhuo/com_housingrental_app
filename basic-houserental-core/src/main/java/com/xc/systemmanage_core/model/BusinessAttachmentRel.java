package com.xc.systemmanage_core.model;
import java.io.Serializable;
import java.sql.Timestamp;
    /*
     *附件业务关联关系表
     *
     */
public class BusinessAttachmentRel implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *关联关系标示
     *
     */
    private String attachRelUuid;
    /**
     *附件标示
     *
     */
    private String attachUuid;
    /**
     *业务标示
     *
     */
    private String businessUuid;
    /**
     *备注
     *
     */
    private String attachMemo;
    /**
     *最后修改时间
     *
     */
    private Timestamp attachRelLastmodifyTime;

    public String getAttachRelUuid(){
        return attachRelUuid;
    }
    
    public void setAttachRelUuid(String attachRelUuids){
        this.attachRelUuid = attachRelUuids;
    }

    public String getAttachUuid(){
        return attachUuid;
    }
    
    public void setAttachUuid(String attachUuids){
        this.attachUuid = attachUuids;
    }


    public String getBusinessUuid() {
		return businessUuid;
	}

	public void setBusinessUuid(String businessUuid) {
		this.businessUuid = businessUuid;
	}

	public String getAttachMemo(){
        return attachMemo;
    }
    
    public void setAttachMemo(String attachMemos){
        this.attachMemo = attachMemos;
    }

    public Timestamp getAttachRelLastmodifyTime(){
        return attachRelLastmodifyTime;
    }
    
    public void setAttachRelLastmodifyTime(Timestamp attachRelLastmodifyTimes){
        this.attachRelLastmodifyTime = attachRelLastmodifyTimes;
    }
    public BusinessAttachmentRel(){
     	super();
	}
    
	public BusinessAttachmentRel(String attachUuid) {
		super();
		this.attachUuid = attachUuid;
	}

	@Override
	public String toString() {
		return "BusinessAttachmentRel ["+""
		 + "attachRelUuid="+attachRelUuid+","
		 + "attachUuid="+attachUuid+","
		 + "businessUuid="+businessUuid+","
		 + "attachMemo="+attachMemo+","
		 + "attachRelLastmodifyTime="+attachRelLastmodifyTime+","
		  + "]";
	}
}