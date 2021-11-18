package com.detay.libraryautomation.service.authorService;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.model.Author;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author getAuthor(long authorId);

    Author createAuthor(AuthorRequest authorRequest);

    Author updateAuthor(long authorId, AuthorRequest authorRequest);

    void deleteAuthor(long authorId);

    List<Author> getAll();

    Optional<Author> getBooks(long authorId);

}
