
package com.models;

import java.math.BigDecimal;
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
    private String serie;
    private int no_doc;
    private BigDecimal exempt;
    private BigDecimal total;
    private BigDecimal iva;
    private BigDecimal net;
    private int userId;
    private String business;
    private String userNit;
    private String buyNit;
    private String buyer;
    private int docTypeId;
    private String docName;

    public Documents(int id, LocalDate documentDate, String serie, int no_doc, BigDecimal exempt, BigDecimal total, BigDecimal iva, BigDecimal net, int userId, String business, String userNit, String buyNit, String buyer, int docTypeId, String docName) {
        this.id = id;
        this.documentDate = documentDate;
        this.serie = serie;
        this.no_doc = no_doc;
        this.exempt = exempt;
        this.total = total;
        this.iva = iva;
        this.net = net;
        this.userId = userId;
        this.business = business;
        this.userNit = userNit;
        this.buyNit = buyNit;
        this.buyer = buyer;
        this.docTypeId = docTypeId;
        this.docName = docName;
    }

    public Documents(Date documentDate, String serie, int no_doc, BigDecimal exempt, BigDecimal total, BigDecimal iva, BigDecimal net, int userId, String buyNit, String buyer, int docTypeId) {
        this.documentDate = documentDate.toLocalDate();
        this.serie = serie;
        this.no_doc = no_doc;
        this.exempt = exempt;
        this.total = total;
        this.iva = iva;
        this.net = net;
        this.userId = userId;
        this.buyNit = buyNit;
        this.buyer = buyer;
        this.docTypeId = docTypeId;
    }

    public Documents(int id, Date documentDate, String serie, int no_doc, BigDecimal exempt, BigDecimal total, BigDecimal iva, BigDecimal net, String buyNit, String buyer, String docName) {
        this.id = id;
        this.documentDate = documentDate.toLocalDate();
        this.serie = serie;
        this.no_doc = no_doc;
        this.exempt = exempt;
        this.total = total;
        this.iva = iva;
        this.net = net;
        this.buyNit = buyNit;
        this.buyer = buyer;
        this.docName = docName;
    }

    public Documents(int id, BigDecimal total, BigDecimal iva, BigDecimal net, String buyNit, String buyer) {
        this.id = id;
        this.total = total;
        this.iva = iva;
        this.net = net;
        this.buyNit = buyNit;
        this.buyer = buyer;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNo_doc() {
        return no_doc;
    }

    public void setNo_doc(int no_doc) {
        this.no_doc = no_doc;
    }

    public BigDecimal getExempt() {
        return exempt;
    }

    public void getExempt(BigDecimal exempt) {
        this.exempt = exempt;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getUserNit() {
        return userNit;
    }

    public void setUserNit(String userNit) {
        this.userNit = userNit;
    }

    public String getBuyNit() {
        return buyNit;
    }

    public void setBuyNit(String buyNit) {
        this.buyNit = buyNit;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(int docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
    
}
