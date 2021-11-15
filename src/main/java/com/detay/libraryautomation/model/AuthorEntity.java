package com.detay.libraryautomation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "author_entity")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long authorId;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    LocalDate yearOfBirth;

    @OneToMany(mappedBy = "author_entity")
    List<BookEntity> bookEntities;

}
