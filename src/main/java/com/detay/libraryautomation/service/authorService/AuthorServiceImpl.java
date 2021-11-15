package com.detay.libraryautomation.service.authorService;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.exception.author.AuthorAlreadyExistException;
import com.detay.libraryautomation.exception.author.AuthorNotFoundException;
import com.detay.libraryautomation.model.AuthorEntity;
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
    public AuthorEntity getAuthor(long authorId) {

        return authorRepository.findById(authorId).orElseThrow();

    }

    @Override
    public AuthorEntity createAuthor(AuthorRequest authorRequest) {

        Optional<AuthorEntity> optionalAuthorEntity = authorRepository.findById(authorRequest.getId());

        if (optionalAuthorEntity.isPresent()) {
            throw new AuthorAlreadyExistException();
        }

        AuthorEntity authorEntity = modelMapper.map(authorRequest, AuthorEntity.class);

        return authorRepository.save(authorEntity);
    }

    @Override
    public AuthorEntity updateAuthor(long authorId, AuthorRequest authorRequest) {

        AuthorEntity newAuthor = authorRepository.findById(authorId).orElseThrow(AuthorAlreadyExistException::new);

        newAuthor.setFirstName(authorRequest.getFirstName());
        newAuthor.setLastName(authorRequest.getLastName());
        newAuthor.setYearOfBirth(authorRequest.getYearOfBirth());

        Optional<AuthorEntity> optionalAuthorEntity = Optional.of(authorRepository.getById(authorId));

        if (newAuthor.getAuthorId() == authorRequest.getId() && optionalAuthorEntity.isPresent()) {
            throw new AuthorAlreadyExistException();
        }

        return authorRepository.save(newAuthor);
    }

    @Override
    public void deleteAuthor(long authorId) {

        AuthorEntity authorEntity = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);

        authorRepository.delete(authorEntity);

    }

    @Override
    public List<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }

}
