package com.detay.libraryautomation.service.libraryService;

import com.detay.libraryautomation.dto.LibraryRequest;
import com.detay.libraryautomation.model.Library;

public interface LibraryService {

    Library getLibrary(long id);

    Library createLibrary(LibraryRequest libraryRequest);

    Library updateLibrary(long id, LibraryRequest libraryRequest);

    void deleteLibrary(long id);

}
