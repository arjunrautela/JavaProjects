package com.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Book;
import com.rest.model.Output;
import com.rest.storage.BookStorage;

@RestController
@RequestMapping("/Inventory/V2")
public class BookControllerV2 {

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Output addBook(@RequestBody Book book) {
		BookStorage bkstr = new BookStorage();
		bkstr.saveBook(book.getIndex(), book);		
		Output output = new Output();
		output.setCode(200);
		output.setMessage("Book Created Successfully");
		return output;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable("id") int id) {
		BookStorage bkstr = new BookStorage();
		return bkstr.getStudent(id);
	}
}
