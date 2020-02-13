package com.example.hamrobook_ebookstore.model;

public class Book {
    private String _id;
    private String BookName;
    private String Category ;
    private String BookContent ;
    private String BookWriter ;

    public Book(String id, String bookName, String category, String bookContent, String bookWriter) {
        this._id = id;
        BookName = bookName;
        Category = category;
        BookContent = bookContent;
        BookWriter = bookWriter;
    }

    public String getBookId() {
        return _id;
    }

    public void setBookId(String id) {
        this._id = id;
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
