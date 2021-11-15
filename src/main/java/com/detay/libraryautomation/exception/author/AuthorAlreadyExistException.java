package com.detay.libraryautomation.exception.author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Error: Author Already Avaible!")
public class AuthorAlreadyExistException extends RuntimeException{
}
