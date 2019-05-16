/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.dao.DocumentTypeDao;
import com.models.DocumentType;

/**
 *
 * @author hely
 */
public class TestDocumentType {

    public static void main(String[] args) {
        boolean inserted = DocumentTypeDao.add(new DocumentType(
                "Factura"));
        System.out.println(inserted);
    }
}
