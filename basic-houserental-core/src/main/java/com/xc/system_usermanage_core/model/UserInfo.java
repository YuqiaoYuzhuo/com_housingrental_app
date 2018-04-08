package com.xc.system_usermanage_core.model;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
    /*
     *用户信息表
     *
     */
public class UserInfo implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *用户标示
     *
     */
    private String userUuid;
    /**
     *用户姓名
     *
     */
    private String userName;
    /**
     *用户地址
     *
     */
    private String userAddr;
    /**
     *注册时间
     *
     */
    private Timestamp userRegTime;
    /**
     *用户邮箱
     *
     */
    private String userEmainl;
    /**
     *用户电话
     *
     */
    private String userTel;
    /**
     *用户状态 
     *
     */
    private Integer userStaus;
    /**
     *用户等级
     *
     */
    private Integer userLevel;
    /**
     *最后修改时间
     *
     */
    private Timestamp userLastModifyTime;
    /**
     *用户性别
     *
     */
    private Integer userGender;
    /**
     *用户生日
     *
     */
    private Date userBirthday;
    /**
     *用户QQ账号
     *
     */
    private String userQqAccount;
    /**
     *用户微信账号
     *
     */
    private String userWxAccout;
    /**
     *用户注册ip
     *
     */
    private String userRegip;
    /**
     *最后登录时间
     *
     */
    private Timestamp userLastLoginTime;
    /**
     *最后登录IP地址
     *
     */
    private String userLastLoginIp;

    public String getUserUuid(){
        return userUuid;
    }
    
    public void setUserUuid(String userUuids){
        this.userUuid = userUuids;
    }

    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userNames){
        this.userName = userNames;
    }

    public String getUserAddr(){
        return userAddr;
    }
    
    public void setUserAddr(String userAddrs){
        this.userAddr = userAddrs;
    }

    public Timestamp getUserRegTime(){
        return userRegTime;
    }
    
    public void setUserRegTime(Timestamp userRegTimes){
        this.userRegTime = userRegTimes;
    }

    public String getUserEmainl(){
        return userEmainl;
    }
    
    public void setUserEmainl(String userEmainls){
        this.userEmainl = userEmainls;
    }

    public String getUserTel(){
        return userTel;
    }
    
    public void setUserTel(String userTels){
        this.userTel = userTels;
    }

    public Integer getUserStaus(){
        return userStaus;
    }
    
    public void setUserStaus(Integer userStauss){
        this.userStaus = userStauss;
    }

    public Integer getUserLevel(){
        return userLevel;
    }
    
    public void setUserLevel(Integer userLevels){
        this.userLevel = userLevels;
    }

    public Timestamp getUserLastModifyTime(){
        return userLastModifyTime;
    }
    
    public void setUserLastModifyTime(Timestamp userLastModifyTimes){
        this.userLastModifyTime = userLastModifyTimes;
    }

    public Integer getUserGender(){
        return userGender;
    }
    
    public void setUserGender(Integer userGenders){
        this.userGender = userGenders;
    }

    public Date getUserBirthday(){
        return userBirthday;
    }
    
    public void setUserBirthday(Date userBirthdays){
        this.userBirthday = userBirthdays;
    }

    public String getUserQqAccount(){
        return userQqAccount;
    }
    
    public void setUserQqAccount(String userQqAccounts){
        this.userQqAccount = userQqAccounts;
    }

    public String getUserWxAccout(){
        return userWxAccout;
    }
    
    public void setUserWxAccout(String userWxAccouts){
        this.userWxAccout = userWxAccouts;
    }

    public String getUserRegip(){
        return userRegip;
    }
    
    public void setUserRegip(String userRegips){
        this.userRegip = userRegips;
    }

    public Timestamp getUserLastLoginTime(){
        return userLastLoginTime;
    }
    
    public void setUserLastLoginTime(Timestamp userLastLoginTimes){
        this.userLastLoginTime = userLastLoginTimes;
    }

    public String getUserLastLoginIp(){
        return userLastLoginIp;
    }
    
    public void setUserLastLoginIp(String userLastLoginIps){
        this.userLastLoginIp = userLastLoginIps;
    }
    public UserInfo(){
     	super();
	}
	@Override
	public String toString() {
		return "UserInfo ["+""
		 + "userUuid="+userUuid+","
		 + "userName="+userName+","
		 + "userAddr="+userAddr+","
		 + "userRegTime="+userRegTime+","
		 + "userEmainl="+userEmainl+","
		 + "userTel="+userTel+","
		 + "userStaus="+userStaus+","
		 + "userLevel="+userLevel+","
		 + "userLastModifyTime="+userLastModifyTime+","
		 + "userGender="+userGender+","
		 + "userBirthday="+userBirthday+","
		 + "userQqAccount="+userQqAccount+","
		 + "userWxAccout="+userWxAccout+","
		 + "userRegip="+userRegip+","
		 + "userLastLoginTime="+userLastLoginTime+","
		 + "userLastLoginIp="+userLastLoginIp+","
		  + "]";
	}
}