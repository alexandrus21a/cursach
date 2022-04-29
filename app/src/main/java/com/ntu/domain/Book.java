package com.ntu.domain;

public class Book {
    private long id;
    private String title;
    private String author;
    private int printYear;
    private int countOfPages;

    public Book() {
    }

    public Book(String title, String author, int printYear, int countOfPages) {
        this.title = title;
        this.author = author;
        this.printYear = printYear;
        this.countOfPages = countOfPages;
    }

    public Book(long id, String title, String author, int printYear, int countOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.printYear = printYear;
        this.countOfPages = countOfPages;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrintYear() {
        return this.printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public int getCountOfPages() {
        return this.countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public String toString() {
        return "Book [id=" + this.id + ", title=" + this.title + ", author=" + this.author + ", printYear=" + this.printYear + ", countOfPages=" + this.countOfPages + "]";
    }
}
