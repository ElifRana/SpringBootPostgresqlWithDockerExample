package com.detay.libraryautomation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long authorId;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    LocalDate yearOfBirth;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")
    private List<Book> bookList;

    public void addBook(List<Book> books){

        books.stream().forEach(book -> {
            book.setAuthor(this);
        });

        this.bookList = books;
    }
}
