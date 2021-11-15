package com.detay.libraryautomation.repository;

import com.detay.libraryautomation.model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {

}
