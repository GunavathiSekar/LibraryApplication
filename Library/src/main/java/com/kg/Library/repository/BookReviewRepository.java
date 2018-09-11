package com.kg.Library.repository;

import java.io.Serializable;
import java.util.List;

import com.kg.Library.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookReviewRepository extends JpaRepository<BookReview, Serializable> {
    @Query(value="select count(DISTINCT BOOKID)*5 FROM BOOK_REVIEW where USERID=:user_id",nativeQuery=true)
    Long findbyreviewId(@Param("user_id") Long user_id);
    public List<BookReview> findByUserid(Long userid);
}