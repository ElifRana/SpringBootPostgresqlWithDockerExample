package com.detay.libraryautomation.dto;

import lombok.Data;

@Data
public class BookRequest {

    int bookId;

    int numberOfPages;

    String bookName;

    String isbn;

    String publisher;
}
