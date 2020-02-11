package com.example.hamrobook_ebookstore.model;

public class Product {
    private String Id;
    private String productName;
    private String productImage;
    private String Writer;
    private String productDescription;
    private String price;
    private String Stock;
    private String Date;



    public Product(String Id,String productName, String productImage, String writer, String productDescription, String price, String stock, String date) {
        this.Id=Id;
        this.productName = productName;
        this.productImage = productImage;
        this.Writer = writer;
        this.productDescription = productDescription;
        this.price = price;
        this.Stock = stock;
        this.Date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
