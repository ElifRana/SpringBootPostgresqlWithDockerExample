package com.detay.libraryautomation.exception.library;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error: Library is not found.")
public class LibraryNotFoundException extends RuntimeException{
}
