package com.detay.libraryautomation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    long bookId;

    int numberOfPages;

    String bookName;

    String isbn;

    String publisher;

    long authorId;

}
