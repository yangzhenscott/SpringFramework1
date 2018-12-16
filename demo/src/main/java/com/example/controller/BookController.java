package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.BookService;

@Controller
public class BookController {

	@Autowired
	public BookService bookService;
}
