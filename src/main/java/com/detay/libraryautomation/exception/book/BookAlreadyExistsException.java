package com.detay.libraryautomation.exception.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Error: Book Already Avaible!")
public class BookAlreadyExistsException extends RuntimeException{
}
