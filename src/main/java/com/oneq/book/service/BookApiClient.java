package com.oneq.book.service;

import com.oneq.book.web.dto.BooksResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BookApiClient {
    private final RestTemplate restTemplate;

    public BooksResponseDto requestBook(String keyword){
        final HttpHeaders headers = new HttpHeaders();
        String CLIENT_ID = "lXRknaqghWIRvvHrJamp";
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        String CLIENT_SECRET = "9CTx6uLaUK";
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        String openNaverBookUrl_getBooks = "https://openapi.naver.com/v1/search/book_adv?d_titl={keyword}";
        return restTemplate.exchange(openNaverBookUrl_getBooks, HttpMethod.GET, entity, BooksResponseDto.class, keyword).getBody();
    }
}
