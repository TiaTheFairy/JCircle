package com.jnu.jcircle.data;

public class class_users {
    private int userID;
    private String userPassword;
    private String userName;
    private String userPic;
    private String userReal;
    private String userPhone;

    public class_users(){

    }
    public class_users(int userID, String userPassword, String userName, String userPic, String userReal, String userPhone) {
        super();
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPic = userPic;
        this.userReal = userReal;
        this.userPhone = userPhone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserReal() {
        return userReal;
    }

    public void setUserReal(String userReal) {
        this.userReal = userReal;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
