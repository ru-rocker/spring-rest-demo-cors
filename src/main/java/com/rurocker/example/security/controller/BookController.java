package com.rurocker.example.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rurocker.example.security.config.CorsConfig;
import com.rurocker.example.security.vo.Book;

/**
 * Controller class for book api.
 * This controller only allows origin from http://www.ru-rocker.com.
 * 
 * See {@link CorsConfig} for more details about the global configuration
 * 
 * @author ru-rocker
 *
 */
@RestController
@RequestMapping("/api-cors")
public class BookController {

	private List<Book> books = new ArrayList<>();

	@RequestMapping(path = "/book", method = RequestMethod.GET)
	public List<Book> getCustomers() {
		return books;
	}

	@RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
	public Book getCustomers(@PathVariable("id") String id) {
		for (Book book : books) {
			if(book.getBookId().equals(id)){
				return book;
			}
		}
		return null;
	}
	
	@RequestMapping(path = "/book", method = RequestMethod.POST)
	public @ResponseBody Book createCustomer(@RequestBody Book customer) {
		books.add(customer);
		return customer;
	}
}
