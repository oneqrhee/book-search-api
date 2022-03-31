package com.oneq.book.web;

import com.oneq.book.service.BooksService;
import com.oneq.book.service.SearchService;
import com.oneq.book.web.dto.bookshelf.BooksSaveRequestDto;
import com.oneq.book.web.dto.search.SearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("search")
public class BookController {

    private final SearchService searchService;

    @GetMapping("")
    public ResponseEntity<?> requestBook(
            @RequestParam String keyword,
            @RequestParam String start){
        return new ResponseEntity<>(SearchService.search(keyword, start), HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> searchDetail(@RequestParam String isbn) {
        return new ResponseEntity<>(SearchService.searchDetail(isbn), HttpStatus.OK);
    }

    @PostMapping("/detail")
    public ResponseEntity<?> save(@RequestParam String isbn) {
        BooksSaveRequestDto result = searchService.save(isbn);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
