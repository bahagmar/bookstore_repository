package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Book;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.BookRepository;

@RestController
@RequestMapping("/api/v1")
public class BookController {
 @Autowired
 private BookRepository bookRepository; 
 //create get all boook api
 public List<Book> getAllBook(){
	return bookRepository.findAll();
 }
 //create book
 @PostMapping("/books")
 public Book createBook (@Validated @RequestBody Book book) {
	 return bookRepository.save(book);
 }
 //get book by id
 @GetMapping("book/{id}")
 public ResponseEntity<Book> getBookbyId(@PathVariable(value="id")int bookId) throws ResourceNotFoundException{
	Book book=bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("book not found"+bookId));
return ResponseEntity.ok() .body(book);
}
//Update book
	@PutMapping ("/Books/{id}")
	public ResponseEntity<Book> updateBook (@PathVariable (value = "id") int Bookid , @RequestBody Book bookDetails) throws ResourceNotFoundException {
		Book book = bookRepository.findById(Bookid).orElseThrow(()->new ResourceNotFoundException("Book not found"+ Bookid));;
		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setPrice(bookDetails.getPrice());
		book.setReleaseDate(bookDetails.getReleaseDate());
		bookRepository.save(book);
		return ResponseEntity.ok().body(book);
		
	}
	// Delete book
	@DeleteMapping("/Books/{id}")
	public ResponseEntity<?> deleteBook (@PathVariable (value = "id") int Bookid) throws ResourceNotFoundException {
		
		Book book = bookRepository.findById(Bookid).orElseThrow(()->new ResourceNotFoundException("Book not found"+ Bookid));;
		return ResponseEntity.ok().build();

	}
}
