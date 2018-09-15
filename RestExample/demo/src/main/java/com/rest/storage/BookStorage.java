package com.rest.storage;

import java.util.HashMap;
import java.util.Map;

import com.rest.model.Book;

public class BookStorage {
	
	private static final Map<Integer, Book> BookMem = new HashMap<Integer, Book>();
	
	public void saveBook(int id, Book book) {
		BookMem.put(id, book);
	}
	
	public Book getStudent(int id) {
		
		return BookMem.get(id);
	}

}
