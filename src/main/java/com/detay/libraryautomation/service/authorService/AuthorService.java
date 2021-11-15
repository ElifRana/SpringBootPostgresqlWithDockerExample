package com.detay.libraryautomation.service.authorService;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.model.AuthorEntity;

import java.util.List;

public interface AuthorService {

    AuthorEntity getAuthor(long authorId);

    AuthorEntity createAuthor(AuthorRequest authorRequest);

    AuthorEntity updateAuthor(long authorId, AuthorRequest authorRequest);

    void deleteAuthor(long authorId);

    List<AuthorEntity> getAll();

}
