/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *Clase que contiene los metodos y el metodo contructor del objeto Comprador
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
public class Buyer {
    private int id;
    private String fullName;
    private String nit;
/**
 * Metodo constructor de Buyer.
 * @param id contiene el id 
 * @param fullName contiene el nombre completo
 * @param nit contiene el Numero de Identificacion Tributaria.
 */
    public Buyer(int id, String fullName, String nit) {
        this.id = id;
        this.fullName = fullName;
        this.nit = nit;
    }
/**
 * Metodo constructor de buyer
 * @param fullName contiene el nombre completo del comprador.
 * @param nit  contiene el Numero NIT
 */
    public Buyer(String fullName, String nit) {
        this.fullName = fullName;
        this.nit = nit;
    }
/**
 * Metodo que obtiene el nombre completo 
 * @return el nombre de buyer.
 */
    public String getFullName() {
        return fullName;
    }
/**
 * Metodo que asigna un nombre completo a Buyer.
 * @param fullName string que contiene el nombre completo.
 */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
/**
 * Metodo para obtener un NIT
 * @return el numero Nit de buyer.
 */
    public String getNit() {
        return nit;
    }
/**
 * Metodo para asignar un Nit 
 * @param nit contiene el nit del comprador.
 */
    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
