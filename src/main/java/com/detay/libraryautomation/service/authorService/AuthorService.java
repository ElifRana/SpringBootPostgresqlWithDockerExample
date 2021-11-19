package com.detay.libraryautomation.service.authorService;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.model.Author;
import java.util.List;

public interface AuthorService {

    Author getAuthor(long authorId);

    Author createAuthor(AuthorRequest authorRequest);

    Author updateAuthor(long authorId, AuthorRequest authorRequest);

    void deleteAuthor(long authorId);

    List<Author> getAll();

}
