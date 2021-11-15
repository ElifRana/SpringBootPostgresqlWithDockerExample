package com.detay.libraryautomation.repository;

import com.detay.libraryautomation.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    Optional<BookEntity> getByIsbn(String isbn);

    Optional<BookEntity> getByBookName(String bookName);

}
