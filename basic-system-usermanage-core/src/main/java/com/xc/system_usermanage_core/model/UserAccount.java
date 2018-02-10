package com.xc.system_usermanage_core.model;
import java.io.Serializable;
    /*
     *用户账户表
     *
     */
public class UserAccount implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *用户账户标示
     *
     */
    private String userAccountUuid;
    /**
     *用户账号
     *
     */
    private String uaserAccountNum;
    /**
     *用户密码
     *
     */
    private String userAccountPassword;
    /**
     *用户账号类型
     *
     */
    private String userAccountType;
    /**
     *用户账号状态
     *
     */
    private Integer userAccountStaus;
    /**
     *用户标示
     *
     */
    private String userAccUserUuid;
    /**
     *用户密码错误次数
     *
     */
    private Integer errorNum;
    /**
     *用户角色账号编码
     *
     */
    private String userAccountCode;
    /**
     *用户角色中文名称
     *
     */
    private String userAccountName;

    public String getUserAccountUuid(){
        return userAccountUuid;
    }
    
    public void setUserAccountUuid(String userAccountUuids){
        this.userAccountUuid = userAccountUuids;
    }

    public String getUaserAccountNum(){
        return uaserAccountNum;
    }
    
    public void setUaserAccountNum(String uaserAccountNums){
        this.uaserAccountNum = uaserAccountNums;
    }

    public String getUserAccountPassword(){
        return userAccountPassword;
    }
    
    public void setUserAccountPassword(String userAccountPasswords){
        this.userAccountPassword = userAccountPasswords;
    }

    public String getUserAccountType(){
        return userAccountType;
    }
    
    public void setUserAccountType(String userAccountTypes){
        this.userAccountType = userAccountTypes;
    }

    public Integer getUserAccountStaus(){
        return userAccountStaus;
    }
    
    public void setUserAccountStaus(Integer userAccountStauss){
        this.userAccountStaus = userAccountStauss;
    }

    public String getUserAccUserUuid(){
        return userAccUserUuid;
    }
    
    public void setUserAccUserUuid(String userAccUserUuids){
        this.userAccUserUuid = userAccUserUuids;
    }

    public Integer getErrorNum(){
        return errorNum;
    }
    
    public void setErrorNum(Integer errorNums){
        this.errorNum = errorNums;
    }

    public String getUserAccountCode(){
        return userAccountCode;
    }
    
    public void setUserAccountCode(String userAccountCodes){
        this.userAccountCode = userAccountCodes;
    }

    public String getUserAccountName(){
        return userAccountName;
    }
    
    public void setUserAccountName(String userAccountNames){
        this.userAccountName = userAccountNames;
    }
    public UserAccount(){
     	super();
	}
	@Override
	public String toString() {
		return "UserAccount ["+""
		 + "userAccountUuid="+userAccountUuid+","
		 + "uaserAccountNum="+uaserAccountNum+","
		 + "userAccountPassword="+userAccountPassword+","
		 + "userAccountType="+userAccountType+","
		 + "userAccountStaus="+userAccountStaus+","
		 + "userAccUserUuid="+userAccUserUuid+","
		 + "errorNum="+errorNum+","
		 + "userAccountCode="+userAccountCode+","
		 + "userAccountName="+userAccountName+","
		  + "]";
	}
}