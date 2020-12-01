package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entites.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
