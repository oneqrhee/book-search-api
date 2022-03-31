package com.oneq.book.service;

import com.oneq.book.domain.Books;
import com.oneq.book.domain.BooksRepository;
import com.oneq.book.web.dto.BooksListResponseDto;
import com.oneq.book.web.dto.BooksResponseDto;
import com.oneq.book.web.dto.BooksSaveRequestDto;
import com.oneq.book.web.dto.BooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class BooksService {

    private final RestTemplate restTemplate;

    public BooksResponseDto requestBook(String keyword) {
        final HttpHeaders headers = new HttpHeaders();
        String CLIENT_ID = "lXRknaqghWIRvvHrJamp";
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        String CLIENT_SECRET = "9CTx6uLaUK";
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        String openNaverBookUrl_getBooks = "https://openapi.naver.com/v1/search/book_adv?d_titl={keyword}";
        return restTemplate.exchange(openNaverBookUrl_getBooks, HttpMethod.GET, entity, BooksResponseDto.class, keyword).getBody();
    }

    private final BooksRepository booksRepository;

    @Transactional
    public Long save(BooksSaveRequestDto requestDto){
        return booksRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BooksUpdateRequestDto requestDto){
        Books books = booksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 책이 없습니다. id="+ id));

        books.update(requestDto.getTitle(), requestDto.getAuthor(), requestDto.getIsbn(), requestDto.getLink(), requestDto.getImage(), requestDto.getPubdate());
        return id;
    }

    @Transactional
    public void delete (Long id){
        Books posts = booksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        booksRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public List<BooksListResponseDto> findAllDesc(){
        return booksRepository.findAllDesc().stream().map(BooksListResponseDto::new).collect(Collectors.toList());
    }
}
