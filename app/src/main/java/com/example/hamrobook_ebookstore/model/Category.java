package com.example.hamrobook_ebookstore.model;

public class Category {
    private String categoryimage;
    private String categoryname, _id;


    public Category(String categoryimage, String categoryname, String _id) {
        this.categoryimage = categoryimage;
        this.categoryname = categoryname;
        this._id = _id;
    }

    public String getCategoryimage() {
        return categoryimage;
    }

    public void setCategoryimage(String categoryimage) {
        this.categoryimage = categoryimage;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
