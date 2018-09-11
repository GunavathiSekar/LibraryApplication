package com.kg.Library.repository;

import java.io.Serializable;

import com.kg.Library.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Serializable> {


}