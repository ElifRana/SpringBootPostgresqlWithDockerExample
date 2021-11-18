package com.detay.libraryautomation.repository;

import com.detay.libraryautomation.model.Author;
import com.detay.libraryautomation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    Optional<Book> getByIsbn(String isbn);
//
//    Book getByLibrary_id(long id);
//
//    Optional<Book> findByBookIdAndAuthorId(long bookId, long authorId);


}
