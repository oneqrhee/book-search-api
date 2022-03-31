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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)

public class BooksService {

    private static final String id = "lXRknaqghWIRvvHrJamp";
    private static final String secret = "9CTx6uLaUK";
    private static final String URL = "https://openapi.naver.com/v1/search/book.json?display=20";
    private final BooksRepository booksRepository;


    public static BooksResponseDto search(String keyword, String start) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = getHttpEntity();
        URI targetUrl = UriComponentsBuilder
                .fromUriString(URL)
                .queryParam("query", keyword)
                .queryParam("start", start)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();
        return restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, BooksResponseDto.class).getBody();
    }

    private static HttpEntity<String> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Naver-Client-Id", id);
        httpHeaders.set("X-Naver-Client-Secret", secret);
        return new HttpEntity<>(httpHeaders);
    }

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
