package com.example.hamrobook_ebookstore.model;

public class Book {
    private String BookName;
    private String Category ;
    private String BookContent ;
    private String BookWriter ;

    public Book(String bookName, String category, String bookContent, String bookWriter) {
        BookName = bookName;
        Category = category;
        BookContent = bookContent;
        BookWriter = bookWriter;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getBookContent() {
        return BookContent;
    }

    public void setBookContent(String bookContent) {
        BookContent = bookContent;
    }

    public String getBookWriter() {
        return BookWriter;
    }

    public void setBookWriter(String bookWriter) {
        BookWriter = bookWriter;
    }
}
