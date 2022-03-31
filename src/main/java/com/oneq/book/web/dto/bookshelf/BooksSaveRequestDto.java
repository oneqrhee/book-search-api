package com.oneq.book.web.dto.bookshelf;

import com.oneq.book.domain.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSaveRequestDto {
    private String title;
    private String author;
    private String isbn;
    private String link;
    private String image;
    private String publisher;
    private String description;

    @Builder
    public BooksSaveRequestDto(String title, String link, String image, String author,
                               String isbn, String publisher, String description) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.description = description;
    }

    public Books toEntity(){
        return Books.builder()
                .title(title)
                .link(link)
                .image(image)
                .author(author)
                .isbn(isbn)
                .publisher(publisher)
                .description(description)
                .build();
    }
}
