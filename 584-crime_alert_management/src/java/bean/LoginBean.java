/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LoginBean {
    public String username;
    public String password;
    
    public LoginBean(){
        username = "";
        password = "";
    }

    public LoginBean(String username, String pasword) {
        this.username = username;
        this.password = pasword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
   
}
