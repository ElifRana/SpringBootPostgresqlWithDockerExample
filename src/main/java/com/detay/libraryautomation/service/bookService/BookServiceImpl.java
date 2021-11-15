package com.detay.libraryautomation.service.bookService;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.exception.book.BookAlreadyExistsException;
import com.detay.libraryautomation.exception.book.BookNotFoundException;
import com.detay.libraryautomation.model.BookEntity;
import com.detay.libraryautomation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookEntity getBook(int bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    @Override
    public BookEntity createBook(BookRequest bookRequest) {

        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookRequest.getBookId());

        if (optionalBookEntity.isPresent()){
            throw new BookAlreadyExistsException();
        }

        BookEntity bookEntity = modelMapper.map(bookRequest, BookEntity.class);

        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity updateBook(int bookId, BookRequest bookRequest) {

        BookEntity newBook = bookRepository.findById(bookId).orElseThrow(BookAlreadyExistsException::new);

        newBook.setBookName(bookRequest.getBookName());
        newBook.setNumberOfPages(bookRequest.getNumberOfPages());
        newBook.setIsbn(bookRequest.getIsbn());
        newBook.setPublisher(bookRequest.getPublisher());

        Optional<BookEntity> optionalBookEntity = bookRepository.getByIsbn(bookRequest.getIsbn());

        if (newBook.getIsbn() == bookRequest.getIsbn() && optionalBookEntity.isPresent()) {
            throw new BookAlreadyExistsException();
        }

        optionalBookEntity = bookRepository.getByBookName(bookRequest.getBookName());
        if (newBook.getBookName() == bookRequest.getBookName() && optionalBookEntity.isPresent()) {
            throw new BookAlreadyExistsException();
        }

        return bookRepository.save(newBook);
    }

    @Override
    public void deleteBook(int bookId) {

        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

        bookRepository.delete(bookEntity);

    }

    @Override
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }
}
