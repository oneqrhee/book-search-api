package com.oneq.book.web;

import com.oneq.book.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
