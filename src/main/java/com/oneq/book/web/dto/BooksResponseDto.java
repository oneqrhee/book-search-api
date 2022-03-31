package com.oneq.book.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BooksResponseDto {
    private int display;
    private Item[] items;

    @Data
    static class Item{
        private String title;
        private String link;
        private String image;
        private String author;
        private String isbn;
        private String pubdate;
    }
}
