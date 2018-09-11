package com.kg.Library.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookrevid;
    @Column
    private Long bookid;
    @Column
    private Long userid;
    @Column
    private String review;

    public void setBookrevid(Long bookrevid) {
        this.bookrevid = bookrevid;
    }

    public Long getBookrevid() {
        return bookrevid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setreview(String review) {
        this.review = review;
    }

    public String getreview() {
        return review;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    @Override
    public String toString() {
        return bookrevid + " " + bookid + " " + review + " " + userid;
    }
}