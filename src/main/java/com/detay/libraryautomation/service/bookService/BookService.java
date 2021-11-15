package com.detay.libraryautomation.service.bookService;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.model.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity getBook(int bookId);

    BookEntity createBook(BookRequest bookRequest);

    BookEntity updateBook(int bookId, BookRequest bookRequest);

    void deleteBook(int bookId);

    List<BookEntity> getAll();

}
