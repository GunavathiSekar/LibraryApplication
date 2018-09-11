package com.kg.Library.repository;

import java.io.Serializable;
import java.util.List;
import com.kg.Library.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRequestRepository extends JpaRepository<BookRequest, Serializable> 
{
    @Query(value="select distinct(b.BOOKCAT_ID ) from BOOK b,BOOK_REQUEST br where br.BOOKID=b.BOOK_ID and br.USERID=:user_id",nativeQuery=true)
    Long findbyuserid(@Param("user_id") Long user_id);
    // @Query(value="select distinct(b.BOOKCAT_ID ),c.NAME from BOOK_REQUEST br join BOOK b on br.BOOKID=b.BOOK_ID join Book_Category c on b.bookcat_id=c.bookcat_id where br.USERID=:user_id",nativeQuery=true)
    // Iterable<BookRequest> findbyuserid(@Param("user_id") Long user_id);
    // @Query(value="SELECT COUNT(DISTINCT br.BOOKID),COUNT(DISTINCT b.BOOKCAT_ID),COUNT(DISTINCT rv.BOOKID)*5 FROM BOOK_REQUEST br,BOOK b,BOOK_REVIEW rv WHERE b.BOOK_ID=br.BOOKID AND b.BOOK_ID=rv.BOOKID AND rv.USERID=:user_id",nativeQuery=true)
    // Iterable<BookRequest> findbyuserid(@Param("user_id") Long user_id);
    // public List<BookRequest> findByUserid(Long userid);
    public List<BookRequest> findByUserid(Long userid);
}