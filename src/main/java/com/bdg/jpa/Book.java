package com.bdg.jpa;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Tigran
 */

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private int pageCount;


    @Column
    private LocalDate publishDate;


    public Book() {
    }


    public Book(String title, int pageCount, LocalDate publishDate) {
        this.title = title;

        this.pageCount = pageCount;
        this.publishDate = publishDate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
