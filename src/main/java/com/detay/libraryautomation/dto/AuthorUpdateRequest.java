package com.detay.libraryautomation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorUpdateRequest {

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    LocalDate yearOfBirth;

    @JsonIgnore
    List<BookRequest> books;

}