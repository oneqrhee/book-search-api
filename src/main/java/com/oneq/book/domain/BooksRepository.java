package com.oneq.book.domain;

import com.oneq.book.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long>{
    @Query("SELECT b FROM Books b ORDER BY b.id DESC")
    List<Books> findAllDesc();
}
