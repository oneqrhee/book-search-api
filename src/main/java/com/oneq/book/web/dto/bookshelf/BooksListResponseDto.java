package com.oneq.book.web.dto.bookshelf;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oneq.book.domain.Books;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter

public class BooksListResponseDto {
    private final Long id;
    private final String title;
    private final String author;
    private final String isbn;
    private final String link;
    private final String image;
    private final String publisher;
    private final String description;
    private final LocalDateTime modifiedDate;

    public BooksListResponseDto(Books entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.isbn = entity.getIsbn();
        this.link = entity.getLink();
        this.image = entity.getImage();
        this.publisher = entity.getPublisher();
        this.description = entity.getDescription();
        this.modifiedDate = entity.getModifiedDate();
    }
}
