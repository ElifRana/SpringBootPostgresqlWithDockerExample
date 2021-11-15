package com.detay.libraryautomation.service.libraryService;

import com.detay.libraryautomation.model.LibraryEntity;
import com.detay.libraryautomation.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Override
    public LibraryEntity getLibrary(int id) {

        return libraryRepository.findById(id).orElseThrow();
    }
}
