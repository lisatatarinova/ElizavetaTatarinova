package com.epam.tc.hw2.testData;

public class User {
    String username;
    String password;
    String loginName;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    User(){
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(){
        return "username: " + this.username + "\n"
                + "loginName: " + this.loginName;
    }

    public String getLoginName(){
        UsersParser usersParser = new UsersParser();
        this.loginName = usersParser.getUserName(this.username, this.password);
        return loginName;
    }
}
