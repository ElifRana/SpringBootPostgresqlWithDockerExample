package com.detay.libraryautomation.exception.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error: Book is not found.")
public class BookNotFoundException extends RuntimeException{
}
