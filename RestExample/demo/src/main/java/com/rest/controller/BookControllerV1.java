package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Book;
import com.rest.storage.BookStorage;

@RestController
@RequestMapping("/Inventory/V1")
public class BookControllerV1 {

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public HttpStatus addBook(@RequestBody Book book) {
		BookStorage bkstr = new BookStorage();
		bkstr.saveBook(book.getIndex(), book);		
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable("id") int id) {
		BookStorage bkstr = new BookStorage();
		return bkstr.getStudent(id);
	}
}
