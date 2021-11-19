package com.detay.libraryautomation.service.libraryService;

import com.detay.libraryautomation.dto.LibraryRequest;
import com.detay.libraryautomation.model.Library;
import java.util.List;

public interface LibraryService {

    Library getLibrary(long libraryId);

    Library createLibrary(LibraryRequest libraryRequest);

    Library updateLibrary(long libraryId, LibraryRequest libraryRequest);

    void deleteLibrary(long libraryId);

    List<Library> getAll();
}
