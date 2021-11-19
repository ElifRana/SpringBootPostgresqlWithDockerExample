package com.detay.libraryautomation.service.libraryService;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.dto.LibraryRequest;
import com.detay.libraryautomation.exception.library.LibraryAlreadyExistsException;
import com.detay.libraryautomation.exception.library.LibraryNotFoundException;
import com.detay.libraryautomation.model.Book;
import com.detay.libraryautomation.model.Library;
import com.detay.libraryautomation.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    private final ModelMapper modelMapper;

    @Override
    public Library getLibrary(long libraryId) {

        return libraryRepository.findById(libraryId).orElseThrow();
    }

    @Override
    public Library createLibrary(LibraryRequest libraryRequest) {

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryRequest.getLibraryId());
        if (optionalLibrary.isPresent()) {
            throw new LibraryAlreadyExistsException();
        }

        Library library = modelMapper.map(libraryRequest, Library.class);

        return libraryRepository.save(library);
    }

    @Override
    public Library updateLibrary(long libraryId, LibraryRequest libraryRequest) {

        Library newLibrary = libraryRepository.findById(libraryId).orElseThrow(LibraryAlreadyExistsException::new);

        newLibrary.setName(libraryRequest.getName());

        return libraryRepository.save(newLibrary);
    }

    @Override
    public void deleteLibrary(long libraryId) {

        Library library = libraryRepository.findById(libraryId).orElseThrow(LibraryNotFoundException::new);

        libraryRepository.delete(library);

    }

    @Override
    public List<Library> getAll() {
        return libraryRepository.findAll();
    }
}
