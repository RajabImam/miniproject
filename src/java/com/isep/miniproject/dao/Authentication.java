/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.miniproject.dao;

import com.isep.miniproject.models.AuthenticationModel;

/**
 *
 * @author RAJAB IMAM
 */
public class Authentication {
    
    public String userAuthentication(AuthenticationModel authModel){
        String login = authModel.getLogin();
        String password = authModel.getPassword();
        
        if (login.equals("Rajab") && password.equals("pass")) {
            return "SUCCESS";
        }
        
        
        return "ErrMessage";
    }
}
