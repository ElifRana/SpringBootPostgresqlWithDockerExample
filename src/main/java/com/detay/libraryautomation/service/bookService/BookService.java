package com.detay.libraryautomation.service.bookService;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.model.Book;
import java.util.List;

public interface BookService {

    Book getBook(long bookId);

    Book createBook(BookRequest bookRequest);

    Book updateBook(long bookId, BookRequest bookRequest);

    void deleteBook(long bookId);

    List<Book> getAll();

}
