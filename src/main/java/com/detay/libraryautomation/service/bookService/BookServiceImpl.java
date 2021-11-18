package com.detay.libraryautomation.service.bookService;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.exception.book.BookAlreadyExistsException;
import com.detay.libraryautomation.exception.book.BookNotFoundException;
import com.detay.libraryautomation.model.Book;
import com.detay.libraryautomation.repository.AuthorRepository;
import com.detay.libraryautomation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public Book getBook(long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    @Override
    public Book createBook(long bookId, BookRequest bookRequest) {

        Optional<Book> optionalBookEntity = bookRepository.findById(bookRequest.getBookId());
        if (optionalBookEntity.isPresent()) {
            throw new BookAlreadyExistsException();
        }
        Book book = modelMapper.map(bookRequest, Book.class);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(long bookId, BookRequest bookRequest) {

        Book newBook = bookRepository.findById(bookId).orElseThrow(BookAlreadyExistsException::new);

        newBook.setBookName(bookRequest.getBookName());
        newBook.setNumberOfPages(bookRequest.getNumberOfPages());
        newBook.setIsbn(bookRequest.getIsbn());
        newBook.setPublisher(bookRequest.getPublisher());

        if (newBook.getIsbn() == bookRequest.getIsbn()) {
            throw new BookAlreadyExistsException();
        }

        return bookRepository.save(newBook);
    }

    @Override
    public void deleteBook(long bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

        bookRepository.delete(book);

    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

}
