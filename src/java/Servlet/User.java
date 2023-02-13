/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author 886152
 */
public class User {

    private String username;

    public String getUsername() {
        return username;
    }

    public User(String userName) {
        this.setUsername(userName);
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
