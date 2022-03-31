package com.oneq.book.web;

import com.oneq.book.service.BooksService;
import com.oneq.book.web.dto.bookshelf.BooksListResponseDto;
import com.oneq.book.web.dto.bookshelf.BooksResponseDto;
import com.oneq.book.web.dto.bookshelf.BooksSaveRequestDto;
import com.oneq.book.web.dto.bookshelf.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class BooksApiController {

    private final BooksService booksService;

    @PutMapping("books/{id}")
    public Long update(@PathVariable Long id, @RequestBody BooksUpdateRequestDto requestDto){
        return booksService.update(id, requestDto);
    }

    @GetMapping("books/{id}")
    public BooksResponseDto findById(@PathVariable Long id){
        return booksService.findById(id);
    }

    @GetMapping("books/bookshelf")
    public List<BooksListResponseDto> findAllDesc(){
        return booksService.findAllDesc();
    }

    @DeleteMapping("books/{id}")
    public Long delete(@PathVariable Long id){
        booksService.delete(id);
        return id;
    }
}
