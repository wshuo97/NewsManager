package cn.web.wshuo.entity;

import java.io.Serializable;

/**
 * Created by Apex_WS at 15:33 on 2017/12/30.
 */

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 4294967296L;

    private String userName;
    private String passWord;
    private String powerGroup;

    public UserEntity() {
    }

    public UserEntity(String userName, String passWord, String powerGroup) {
        this.userName = userName;
        this.passWord = passWord;
        this.powerGroup = powerGroup;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPowerGroup() {
        return powerGroup;
    }

    public void setPowerGroup(String powerGroup) {
        this.powerGroup = powerGroup;
    }

    @Override
    public String toString() {
        return "userName: " + this.userName + ";passWord: " + this.passWord + ";powerGroup: " + this.powerGroup;
    }
}















