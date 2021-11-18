package com.detay.libraryautomation.repository;

import com.detay.libraryautomation.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
