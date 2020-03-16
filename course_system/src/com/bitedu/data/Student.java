package com.bitedu.data;
//数据处理模块
public class Student {
    private int sn;
    private String name;
    private int classid;

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "sn=" + sn +", name='" + name + '\'' +", classid=" + classid ;
    }
}
