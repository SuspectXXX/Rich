package com.rich.rich.bean;

import java.util.Date;
import java.util.List;

public class Querys {
    private int id;
    private String power;
    private String[] powerImagePath;
    private String tempure;
    private String[] tempureImagePath;
    private Date date;
    private String name;

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", power=" + power +
                ", powerImagePath='" + powerImagePath + '\'' +
                ", tempure=" + tempure +
                ", tempureImagePath='" + tempureImagePath + '\'' +
                ", date=" + date +
                ", name=" + name +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTempure() {
        return tempure;
    }

    public void setTempure(String tempure) {
        this.tempure = tempure;
    }

    public String[] getPowerImagePath() {
        return powerImagePath;
    }

    public void setPowerImagePath(String[] powerImagePath) {
        this.powerImagePath = powerImagePath;
    }

    public String[] getTempureImagePath() {
        return tempureImagePath;
    }

    public void setTempureImagePath(String[] tempureImagePath) {
        this.tempureImagePath = tempureImagePath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
