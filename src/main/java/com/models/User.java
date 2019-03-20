
package com.models;

/**
 *Clase que contiene contructores y metodos para los usuarios.
 * @author hely
 * @version 1.0
 * @since salesBook 1.0
 */
public class User {
    
    private int id;
    private String fullName;
    private String userName;
    private String password;
    private String businessName;
    private String nit;

    public User(int id, String fullName, String userName, String password, String businessName, String nit) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.businessName = businessName;
        this.nit = nit;
    }

    public User(String fullName, String userName, String password, String businessName, String nit) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.businessName = businessName;
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
}