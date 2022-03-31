package com.oneq.book.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksResponseDto {

    public Integer total;
    public Integer display;
    List<Items> items = new ArrayList<>();

    static class Items{
        public String title;
        public String image;
        public String author;
        public String isbn;
        public String pubdate;
        public String description;
    }
}
