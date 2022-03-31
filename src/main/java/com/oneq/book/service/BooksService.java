package com.oneq.book.service;

import com.oneq.book.domain.Books;
import com.oneq.book.domain.BooksRepository;
import com.oneq.book.web.dto.bookshelf.BooksListResponseDto;
import com.oneq.book.web.dto.bookshelf.BooksResponseDto;
import com.oneq.book.web.dto.bookshelf.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)

public class BooksService {

    private final BooksRepository booksRepository;

    @Transactional
    public Long update(Long id, BooksUpdateRequestDto requestDto) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 책이 없습니다. id=" + id));

        books.update(
                requestDto.getTitle(),
                requestDto.getAuthor(),
                requestDto.getIsbn(),
                requestDto.getLink(),
                requestDto.getImage(),
                requestDto.getPublisher(),
                requestDto.getDescription());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        booksRepository.delete(books);
    }

    @Transactional(readOnly = true)
    public BooksResponseDto findById(Long id) {
        Books entity = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 책이 없습니다. id=" + id));

        return new BooksResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BooksListResponseDto> findAllDesc() {
        return booksRepository.findAllDesc().stream()
                .map(BooksListResponseDto::new)
                .collect(Collectors.toList());
    }
}
