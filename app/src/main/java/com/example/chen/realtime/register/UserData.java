package com.example.chen.realtime.register;

/**
 * Created by Administrator on 2017/10/30.
 */

public class UserData {

    private String userName;
    private String userPwd;
    private int userId;
    public int pwdresetFlag = 0;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPwdresetFlag() {
        return pwdresetFlag;
    }

    public void setPwdresetFlag(int pwdresetFlag) {
        this.pwdresetFlag = pwdresetFlag;
    }

    public UserData(String userName, String userPwd) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
