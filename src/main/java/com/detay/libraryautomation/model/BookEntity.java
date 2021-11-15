package com.detay.libraryautomation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "book_entity")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;

    int numberOfPages;

    String bookName;

    String isbn;

    String publisher;

    @ManyToOne
    @JoinColumn(name = "library_entity_id")
    private LibraryEntity libraryEntity;

    @ManyToOne
    @JoinColumn(name = "author_entity_id")
    private AuthorEntity authorEntity;

}
