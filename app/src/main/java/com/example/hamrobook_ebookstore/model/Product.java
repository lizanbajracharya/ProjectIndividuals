package com.example.hamrobook_ebookstore.model;

public class Product {
    private String productName;
    private String productImage;
    private String Writer;
    private String productDescription;
    private String price;
    private String Stock;

    public Product(String productName, String productImage, String writer, String productDescription, String price, String stock) {
        this.productName = productName;
        this.productImage = productImage;
        Writer = writer;
        this.productDescription = productDescription;
        this.price = price;
        Stock = stock;
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
}
