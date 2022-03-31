package com.oneq.book.web;

import com.oneq.book.service.BookForm;
import com.oneq.book.service.BooksService;
import com.oneq.book.web.dto.BooksResponseDto;
import com.oneq.book.service.BookApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("search")
public class BookController {

    private final BooksService booksService;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("books", booksService.findAllDesc());
//        return "index.html";
//    }

    @GetMapping("")
    public ResponseEntity<?> requestBook(
            @RequestParam String keyword,
            @RequestParam String start){
        log.info("[Request] search");
        return new ResponseEntity<>(BooksService.search(keyword, start), HttpStatus.OK);
    }
}
