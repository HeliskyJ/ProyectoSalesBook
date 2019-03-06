
package com.models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *Clase que contiene los contructores y los metodos para el objeto Documento. 
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
public class Documents {
    private int id;
    private LocalDate documentDate;
    private String serialNumber;
    private boolean isExempt;
    private double total;
    private double iva;
    private int userId;
    private int buyerId;
    private int docTypeId;
/**
 * Metodo constructor del Documento.
 * @param id
 * @param documentDate
 * @param serialNumber
 * @param isExempt
 * @param total
 * @param iva
 * @param userId
 * @param buyerId
 * @param docTypeId 
 */
    public Documents( LocalDate documentDate, String serialNumber, boolean isExempt, double total, double iva, int userId, int buyerId, int docTypeId) {
       
        this.documentDate = documentDate;
        this.serialNumber = serialNumber;
        this.isExempt = isExempt;
        this.total = total;
        this.iva = iva;
        this.userId = userId;
        this.buyerId = buyerId;
        this.docTypeId = docTypeId;
    }
/**
 * Metodo constructor dos del Documento.
 * @param documentDate
 * @param serialNumber
 * @param isExempt
 * @param total
 * @param iva
 * @param userId
 * @param buyerId
 * @param docTypeId 
 */
    
    public Documents(Date documentDate, String serialNumber, double total, double iva, int userId, int buyerId, int docTypeId) {
        this.documentDate = documentDate.toLocalDate();
        this.serialNumber = serialNumber;
        this.total = total;
        this.iva = iva;
        this.userId = userId;
        this.buyerId = buyerId;
        this.docTypeId = docTypeId;
    }
    /**
 * Metodo constructor dos del Documento.
 * @param documentDate
 * @param serialNumber
 * @param isExempt
 * @param total
 * @param iva
 * @param userId
 * @param buyerId
 * @param docTypeId 
 */
    public Documents(Date documentDate, String serialNumber, boolean isExempt, double total, double iva, int userId, int buyerId, int docTypeId) {
        this.documentDate =documentDate.toLocalDate();
        this.serialNumber = serialNumber;
        this.isExempt = isExempt;
        this.total = total;
        this.iva = iva;
        this.userId = userId;
        this.buyerId = buyerId;
        this.docTypeId = docTypeId;
    }
/**
 * Metodo para obtener el id del documento.
 * @return id del Documento. 
 */
    public int getId() {
        return id;
    }
/**
 * Metodo para obtener la fecha del documento.
 * @return fecha del documento.
 */
    public LocalDate getDocumentDate() {
        return documentDate;
    }
/**
 * Metodo para asignar una fecha al documento.
 * @param documentDate  LocalDate para fecha del documento.
 */
    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }
/**
 * Metodo para obtener el Numero de serie.
 * @return numero de serie.
 */
    public String getSerialNumber() {
        return serialNumber;
    }
/**
 * Metodo para asignar un numero de serie.
 * @param serialNumber string de serie
 */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
/**
 * Metodo para obtener un valor booleano.
 * @return el estado del docuemento.
 */
    public boolean isIsExempt() {
        return isExempt;
    }
/**
 * Metodo para asignar el estado de excenta.
 * @param isExempt saber si el documento es excento o no.
 */
    public void setIsExempt(boolean isExempt) {
        this.isExempt = isExempt;
    }
/**
 * Metodo para obtener el total del documento.
 * @return total del documento.
 */
    public double getTotal() {
        return total;
    }
/**
 * Metodo para asignar el tota del documento.
 * @param total double que contiene la cantidad del documento.
 */
    public void setTotal(double total) {
        this.total = total;
    }
/**
 * Metodo para obtener cantidad de iva
 * @return cantidad del IVA.
 */
    public double getIva() {
        return iva;
    }
/**
 * Metodo para asignar el iva
 * @param iva double que contiene el valor del IVA.
 */
    public void setIva(double iva) {
        this.iva = iva;
    }
/**
 * Metodo para obtener el id del usuario.
 * @return id del usuario 
 */
    public int getUserId() {
        return userId;
    }
/**
 * Metodo para asignar el usuario 
 * @param userId int contiene el id
 */
    public void setUserId(int userId) {
        this.userId = userId;
    }
/**
 * Metodo para obtener el tipo de documento
 * @return id del tipo de documento.
 */
    public int getDocTypeId() {
        return docTypeId;
    }
/**
 * Metodo para asignar un id de tipo de documento
 * @param docTypeId contiene el id del tipo de documento.
 */
    public void setDocTypeId(int docTypeId) {
        this.docTypeId = docTypeId;
    }
/**
 * Metodo para obtener el comprador.
 * @return id del comprador
 */
    public int getBuyerId() {
        return buyerId;
    }
/**
 * Metodo para asignar el comprador.
 * @param buyerId contiene el id del comprador.
 */
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }
    public void setDocumentsDate(int dia, int mes, int anio) {
    this.documentDate= LocalDate.of(anio, mes, dia);
    }
        public String getDateString(){
        return documentDate.toString();
    }
}
