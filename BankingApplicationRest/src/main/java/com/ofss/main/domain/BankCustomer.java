package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_customer")
public class BankCustomer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
    private int customerId;
    @Column(name="is_approved")
    private boolean CustomerisApproved;
    @Column(name="full_name")
    private String fullName;
    @Column(name="address_l1")
    private String addressL1;
    @Column(name="address_l2")
    private String addressL2;
    @Column(name="address_l3")
    private String addressL3;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private int zip;
    @Column(name="phone")
    private String phone;
    @Column(name="cell")
    private String cell;
    @Column(name="email")
    private String email;
    public BankCustomer(){}
    public BankCustomer(boolean isApproved, String fullName, String addressL1, String addressL2,
            String addressL3, String city, String state, int zip, String phone, String cell, String email) {
        this.CustomerisApproved = isApproved;
        this.fullName = fullName;
        this.addressL1 = addressL1;
        this.addressL2 = addressL2;
        this.addressL3 = addressL3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.cell = cell;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isCustomerisApproved() {
        return CustomerisApproved;
    }

    public void setCustomerisApproved(boolean customerisApproved) {
        CustomerisApproved = customerisApproved;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressL1() {
        return addressL1;
    }

    public void setAddressL1(String addressL1) {
        this.addressL1 = addressL1;
    }

    public String getAddressL2() {
        return addressL2;
    }

    public void setAddressL2(String addressL2) {
        this.addressL2 = addressL2;
    }

    public String getAddressL3() {
        return addressL3;
    }

    public void setAddressL3(String addressL3) {
        this.addressL3 = addressL3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
