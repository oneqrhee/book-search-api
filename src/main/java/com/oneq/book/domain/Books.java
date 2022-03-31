package com.oneq.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String author;
    private String isbn;
    private String link;
    private String image;
    private String pubdate;


    @Builder
    public Books(String title, String link, String image, String author, String isbn, String pubdate){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.pubdate = pubdate;
    }

    public void update(String title, String link, String image, String author, String isbn, String pubdate){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.pubdate = pubdate;
    }
}
