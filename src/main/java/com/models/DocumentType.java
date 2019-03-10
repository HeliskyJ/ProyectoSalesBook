/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *Clase que contiene el constructor y los metodos 
 * para el objeto tipo de documento
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
public class DocumentType {
    private int id;
    private String documentName;
/**
 * Metodo constructor de Tipo de Documento.
 * @param id contiene el id del constructor.
 * @param documentName  contiene el nombre del documento.
 */
    public DocumentType(int id, String documentName) {
        this.id = id;
        this.documentName = documentName;
    }
/**
 * Metodo constructor del tipo de documento.
 * @param documentName contiene el nombre del Nombre del documento.
 */
    public DocumentType(String documentName) {
        this.documentName = documentName;
    }
/**
 * Metodo para obtener el nombre del documento
 * @return el nombre del tipo del documento.
 */
    public String getDocumentName() {
        return documentName;
    }
/**
 * Metodo para asignar un Nombre al tipo del documento.
 * @param documentName contiene el nombre del documento.
 */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
