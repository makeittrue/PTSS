package cn.itcast.travel.domain;

import java.io.Serializable;

public class Service implements Serializable {

//    private int uid;//用户id
//    private String username;//用户名，账号
//    private String password;//密码
//    private String lastname;//真实姓名
//    private String firstname;//真实姓名
//    private String sex;//男或女
//    private String telephone;//手机号
//    private String email;//邮箱
//    private String status;//激活状态，Y代表激活，N代表未激活
//    private String code;//激活码（要求唯一

    private int uid;//提供服务的用户id
    private String stitle;//服务名称
    private int sid;//服务的id
    private int cid;//服务类型id
    private float price;//服务的价格
    private String place;//服务的地点
    private String sbody;

    public Service(int uid, String stitle, int sid, float price, String place, int cid){
        this.uid = uid;
        this.stitle = stitle;
        this.sid = sid;
        this.price = price;
        this.place = place;
        this.cid = cid;
    }

    public Service(){}

    public int getUid() {
        return uid;
    }

    public String getStitle()
    {
        return stitle;
    }

    public void setStitle(String stitle){
        this.stitle = stitle;
    }

    public String getSbody()
    {
        return sbody;
    }

    public void setSbody(String sbody){
        this.sbody = sbody;
    }


    public int getCid(){return cid;}

    public void setCid(int cid){
        this.cid = cid;
    }

    public int getSid()
    {
        return sid;
    }

    public float getPrice()
    {
        return price;
    }

    public String getPlace()
    {
        return place;
    }

    public void setUid(int uid){
        this.uid = uid;
    }

    public void setSid(int sid){
        this.sid = sid;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setPlace(String place){
        this.place = place;
    }
}
