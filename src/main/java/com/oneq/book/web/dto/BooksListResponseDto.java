package com.oneq.book.web.dto;

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

    public BooksListResponseDto(Books entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.isbn = entity.getIsbn();
    }
}
