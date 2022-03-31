package com.oneq.book.web;

import com.oneq.book.service.BooksService;
import com.oneq.book.web.dto.BooksResponseDto;
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

    @DeleteMapping("/api/v1/books/{id}")
    public Long delete(@PathVariable Long id){
        booksService.delete(id);
        return id;
    }
}
