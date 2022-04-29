package com.ntu.domain;

import java.io.Serializable;
import java.sql.Date;

public class BookRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private Book book;
    private Date vydanoDt;
    private PersonReader personReader;
    private Date povernenoDt;

    public BookRegister() {
    }

    public BookRegister(Book book, Date vydanoDt, PersonReader personReader, Date povernenoDt) {
        this.book = book;
        this.vydanoDt = vydanoDt;
        this.personReader = personReader;
        this.povernenoDt = povernenoDt;
    }

    public BookRegister(long id, Book book, Date vydanoDt, PersonReader personReader, Date povernenoDt) {
        this.id = id;
        this.book = book;
        this.vydanoDt = vydanoDt;
        this.personReader = personReader;
        this.povernenoDt = povernenoDt;
    }

    public BookRegister(Book book, Date vydanoDt, PersonReader personReader) {
        this.book = book;
        this.vydanoDt = vydanoDt;
        this.personReader = personReader;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getVydanoDt() {
        return this.vydanoDt;
    }

    public void setVydanoDt(Date vydanoDt) {
        this.vydanoDt = vydanoDt;
    }

    public PersonReader getPersonReader() {
        return this.personReader;
    }

    public void setPersonReader(PersonReader personReader) {
        this.personReader = personReader;
    }

    public Date getPovernenoDt() {
        return this.povernenoDt;
    }

    public void setPovernenoDt(Date povernenoDt) {
        this.povernenoDt = povernenoDt;
    }

    public String toString() {
        return "BookRegister [id=" + this.id + ", book=" + this.book.getId() + " - " + this.book.getTitle() + " - " + this.book.getAuthor() + ", vydanoDt=" + this.vydanoDt + ", personReader=" + this.personReader.getId() + " - " + this.personReader.getFirstName() + " - " + this.personReader.getLastName() + " - " + this.personReader.getPhone() + ", povernenoDt=" + this.povernenoDt + "]";
    }
}
