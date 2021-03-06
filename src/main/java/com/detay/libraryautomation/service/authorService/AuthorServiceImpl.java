package com.detay.libraryautomation.service.authorService;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.dto.AuthorUpdateRequest;
import com.detay.libraryautomation.exception.author.AuthorAlreadyExistException;
import com.detay.libraryautomation.exception.author.AuthorNotFoundException;
import com.detay.libraryautomation.model.Author;
import com.detay.libraryautomation.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final ModelMapper modelMapper;

    @Override
    public Author getAuthor(long authorId) {

        return authorRepository.findById(authorId).orElseThrow();

    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {

        Optional<Author> optionalAuthorEntity = authorRepository.findById(authorRequest.getAuthorId());
        if (optionalAuthorEntity.isPresent()) {
            throw new AuthorAlreadyExistException();
        }
        Author author = modelMapper.map(authorRequest, Author.class);
        return authorRepository.save(author);
    }


    @Override
    public Author updateAuthor(long authorId, AuthorUpdateRequest authorUpdateRequest) {

        Author newAuthor = authorRepository.findById(authorId).orElseThrow(AuthorAlreadyExistException::new);

        newAuthor.setFirstName(authorUpdateRequest.getFirstName());
        newAuthor.setLastName(authorUpdateRequest.getLastName());
        newAuthor.setYearOfBirth(authorUpdateRequest.getYearOfBirth());

        return authorRepository.save(newAuthor);
    }

    @Override
    public void deleteAuthor(long authorId) {

        Author author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);

        authorRepository.delete(author);

    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

}
