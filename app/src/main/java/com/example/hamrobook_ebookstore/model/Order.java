package com.example.hamrobook_ebookstore.model;

public class Order {
    private String productname;
    private String rate;
    private String location;
    private String mobilenumber;

    public Order(String productname, String rate, String location, String mobilenumber) {
        this.productname = productname;
        this.rate = rate;
        this.location = location;
        this.mobilenumber = mobilenumber;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
