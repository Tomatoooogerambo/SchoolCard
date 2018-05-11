package com.njupt.entity;

/**
 * Created by 越 on 2018/5/10.
 */
public class Manager {
    private String managerJobNumber;
    private String password;
    private String schoolDistrict;
    private String position;

    public String getManagerJobNumber() {
        return managerJobNumber;
    }

    public void setManagerJobNumber(String managerJobNumber) {
        this.managerJobNumber = managerJobNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    public void setSchoolDistrict(String schoolDistrict) {
        this.schoolDistrict = schoolDistrict;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder managerStr = new StringBuilder();
        managerStr.append("工号：" + getManagerJobNumber() + "\n");
        managerStr.append("校区：" + getSchoolDistrict() + "\n");
        managerStr.append("位置：" + getPosition());
        return managerStr.toString();
    }
}
