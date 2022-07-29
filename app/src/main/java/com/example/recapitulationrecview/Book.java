package com.example.recapitulationrecview;

public class Book {

    private int ID;
    private String bookname;
    private String author;
    private int pages;
    private String imageURL;
    private boolean isExpanded;

    public Book(int ID, String bookname, String author, int pages, String imageURL) {
        this.ID = ID;
        this.bookname = bookname;
        this.author = author;
        this.pages = pages;
        this.imageURL = imageURL;
        isExpanded = false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
