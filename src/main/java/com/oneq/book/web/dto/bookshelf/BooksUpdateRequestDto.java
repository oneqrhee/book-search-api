package com.oneq.book.web.dto.bookshelf;

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
    private String publisher;
    private String description;

    @Builder
    public BooksUpdateRequestDto(String title, String link, String image,
                                 String author, String isbn, String publisher, String description){
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.description = description;
    }
}
