package com.detay.libraryautomation.exception.author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error: Author is not found.")
public class AuthorNotFoundException extends RuntimeException{
}
