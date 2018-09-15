package com.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Book;
import com.rest.model.Output;
import com.rest.storage.BookStorage;

@RestController
@RequestMapping("/Inventory/V3")
public class BookControllerV3 {

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<Output> addBook(@RequestBody Book book) {
		BookStorage bkstr = new BookStorage();
		bkstr.saveBook(book.getIndex(), book);		
		Output output = new Output();
		output.setCode(200);
		output.setMessage("Book Created Successfully");
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.set("x-session-id", "123-456-789");
		return new ResponseEntity<>(output, respHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		BookStorage bkstr = new BookStorage();
		if (bkstr.getStudent(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.set("x-session-id", "123-456-789");
		return new ResponseEntity<>(bkstr.getStudent(id), respHeaders,HttpStatus.OK);
	}
}
