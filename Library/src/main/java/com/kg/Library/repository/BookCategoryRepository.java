package com.kg.Library.repository;

import java.io.Serializable;
import com.kg.Library.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Serializable>
 {


}