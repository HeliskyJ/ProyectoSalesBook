
package com.models;

/**
 *Clase que contiene contructores y metodos para los usuarios.
 * @author hely
 * @version 1.0
 * @since salesBook 1.0
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String businessName;
    private String nit;
/**
 * Metodo contructor del usuario.
 * @param firstName
 * @param lastName
 * @param userName
 * @param password
 * @param businessName
 * @param nit 
 */
    public User(String firstName, String lastName, String userName, String password, String businessName, String nit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.businessName = businessName;
        this.nit = nit;
    }
/**
 * Metodo constructor dos del usuario.
 * @param id
 * @param firstName
 * @param lastName
 * @param userName
 * @param password
 * @param businessName
 * @param nit 
 */
    public User(int id, String firstName, String lastName, String userName, String password, String businessName, String nit) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.businessName = businessName;
        this.nit = nit;
    }
/**
 * Metodo para obtener el nombre del usuario.
 * @return el nombre
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Metodo para asignar el nombre.
 * @param firstName 
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Metodo para obtener el apellido
 * @return el apellido del usuario.
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Metodo para asignar apellidos la usuario
 * @param lastName string para el apellido.
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * Metodo para obtener el username.
 * @return el userName asignado
 */
    public String getUserName() {
        return userName;
    }
/**
 * Metodo para asignar un userName.
 * @param userName String para asignar un nombre de usuario.
 */
    public void setUserName(String userName) {
        this.userName = userName;
    }
/**
 * Metodo para obtener la contraseña
 * @return la contraseña del usuario.
 */
    public String getPassword() {
        return password;
    }
/**
 * Metodo para asignar una contraseña
 * @param password String para obtener contraseña del user.
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Metodo para obtener el nombre del negocio.
 * @return nombre del negocio.
 */
    public String getBusinessName() {
        return businessName;
    }
/**
 * Metodo para asignar Nombre de negocio.
 * @param businessName String que contiene el nombre del negocio.
 */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
/**
 * Metodo para obtener el Nit
 * @return el numero de identificacion tributaria.
 */
    public String getNit() {
        return nit;
    }
/**
 * Metodo para asignar el Numero de Identificacion Tributaria.
 * @param nit String que contiene el Numero.
 */
    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
