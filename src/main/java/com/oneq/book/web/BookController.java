package com.oneq.book.web;

import com.oneq.book.service.BookForm;
import com.oneq.book.service.BooksService;
import com.oneq.book.web.dto.BooksResponseDto;
import com.oneq.book.service.BookApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BooksService booksService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", booksService.findAllDesc());
        return "index.html";
    }

    @PostMapping("/search")
    @ResponseBody
    public BooksResponseDto search(BookForm form) {
        return booksService.requestBook(form.getKeyword());
    }
}
