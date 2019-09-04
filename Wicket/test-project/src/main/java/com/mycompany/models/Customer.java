package com.mycompany.models;

import java.io.Serializable;
import java.util.logging.Logger;

public class Customer implements Serializable {
   
    private static final long serialVersionUID = 1L;
    private String documentId;
    private String name;
    private String lastname;
    private String accountNumber;
    private Address address;

    private final static Logger LOG = Logger.getLogger(Customer.class.getName());

    public Customer() { 
        LOG.info("[CREATING Customer TDD]"); 
    }

    public Customer(String documentId, String name, String lastname, String accountNumber, Address address) {
        LOG.info("[CREATING Customer TDD]"); 

        this.documentId = documentId;
        this.name = name;
        this.lastname = lastname;
        this.accountNumber = accountNumber;
        this.address = address;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [accountNumber=" + accountNumber + ", address=" + address + ", documentId=" + documentId
                + ", lastname=" + lastname + ", name=" + name + "]";
    }
    
    
}
