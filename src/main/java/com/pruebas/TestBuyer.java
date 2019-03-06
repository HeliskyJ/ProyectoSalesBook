/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas;

import com.models.Buyer;

/**
 *
 * @author hely
 */
public class TestBuyer {
    public static void main(String []args){
        boolean inserted = com.dao.BuyerDao.add(new Buyer ("Julian Batuza Molina",
                "12346k"
        ));
        System.out.println(inserted);
    }
}
