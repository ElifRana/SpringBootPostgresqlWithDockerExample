package com.detay.libraryautomation.exception.library;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Error: Library Already Avaible!")
public class LibraryAlreadyExistsException extends RuntimeException{
}
