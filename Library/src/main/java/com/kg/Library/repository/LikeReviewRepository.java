package com.kg.Library.repository;

import java.io.Serializable;
import java.util.List;

import com.kg.Library.model.LikeReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeReviewRepository extends JpaRepository<LikeReview, Serializable> {
    @Query(value="select count from LIKEREVIEW b join BOOKREVIEW a on b.USERID=a.USERID where b.USERID=:user_id",nativeQuery=true)
    Iterable<LikeReview> findbylikeId(@Param("user_id") Long user_id);
    public List<LikeReview> findByUserid(Long userid);

}