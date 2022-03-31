package com.oneq.book.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksUpdateRequestDto {
    private String title;
    private String author;
    private String isbn;
    private String link;
    private String image;
    private String pubdate;

    @Builder
    public BooksUpdateRequestDto(String title, String link, String image, String author, String isbn, String pubdate){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.pubdate = pubdate;
    }
}
