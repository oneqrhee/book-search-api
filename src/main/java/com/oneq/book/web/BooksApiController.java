package com.oneq.book.web;

import com.oneq.book.service.BooksService;
import com.oneq.book.web.dto.BooksResponseDto;
import com.oneq.book.web.dto.SearchDto;
import com.oneq.book.web.dto.BooksSaveRequestDto;
import com.oneq.book.web.dto.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class BooksApiController {

    private final BooksService booksService;

    @PostMapping("/api/v1/books")
    public Long save(@RequestBody BooksSaveRequestDto requestDto){
        return booksService.save(requestDto);
    }

    @PutMapping("/api/v1/books/{id}")
    public Long update(@PathVariable Long id, @RequestBody BooksUpdateRequestDto requestDto){
        return booksService.update(id, requestDto);
    }

    @GetMapping("/api/v1/books/{id}")
    public BooksResponseDto findById(@PathVariable Long id){
        return booksService.findById(id);
    }

    @DeleteMapping("/api/v1/books/{id}")
    public Long delete(@PathVariable Long id){
        booksService.delete(id);
        return id;
    }
}
