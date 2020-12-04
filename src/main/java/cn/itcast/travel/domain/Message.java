package cn.itcast.travel.domain;

public class Message {
    
    private int id;// 用户id
    private String username;// 用户名，账号
    private String message;// 密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
