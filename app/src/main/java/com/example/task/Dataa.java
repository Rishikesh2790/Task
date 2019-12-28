package com.example.task;

public class Dataa
{
    private String name;
    private String id;
    private String code;
    private String type;
    private String starttime;
    private String endtime;
    private String days;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Dataa(String id, String name, String code, String type, String starttime, String endtime, String days) {
        this.name = name;
        this.id=id;
        this.code = code;
        this.starttime = starttime;
        this.endtime = endtime;
        this.type = type;
        this.days=days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


}
