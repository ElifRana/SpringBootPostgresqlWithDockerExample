package com.detay.libraryautomation.model;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.dto.LibraryRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long bookId;

    int numberOfPages;

    String bookName;

    String isbn;

    String publisher;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
   // @JsonIgnoreProperties("bookList")
  //  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Author author;

}
