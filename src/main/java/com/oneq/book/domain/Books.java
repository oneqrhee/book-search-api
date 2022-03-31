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
public class Books extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String author;
    private String isbn;
    private String link;
    private String image;
    private String publisher;
    private String description;


    @Builder
    public Books(String title, String link, String image, String author, String isbn, String publisher, String description){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.description = description;
    }

    public void update(String title, String link, String image, String author, String isbn, String publisher, String description){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.description = description;
    }
}
