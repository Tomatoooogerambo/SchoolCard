package com.njupt.entity;

/**
 * Created by 越 on 2018/4/27.
 */
public class Student {
    // define field
    private String name;
    private String college;
    private String major;
    private String userId;
    private String macNumber;
    private boolean isLost;
    private String telNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMacNumber() {
        return macNumber;
    }

    public void setMacNumber(String macNumber) {
        this.macNumber = macNumber;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        StringBuffer line = new StringBuffer();
        line.append("name: " + getName()+
                "\n" + "college: " + getCollege() +
                "\n" + "major: " + getMajor() +
                "\n" + "userId: " + getUserId() +
                "\n" + "macNumber: " + getMacNumber() +
                "\n" + "isLost: " + isLost() +
                "\n" + "telNumber: " + getTelNumber());
        return line.toString();
    }
}
