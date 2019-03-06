/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas;

import com.dao.UserDao;
import com.models.User;

/**
 *
 * @author hely
 */
public class PruebaUser {
    public static void main(String []args){
        
        boolean inserted =  UserDao.add(new User("Pablo Jose", 
                "Robles Hernandez", "Loli", "123", "Los Laureles", "7558674k"));
        System.out.println(inserted);
    }
}
