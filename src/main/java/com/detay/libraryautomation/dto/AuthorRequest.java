package com.detay.libraryautomation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorRequest {

    long id;

    String firstName;

    String lastName;

    LocalDate yearOfBirth;
}
