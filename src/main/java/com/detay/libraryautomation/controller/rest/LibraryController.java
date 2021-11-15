package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.model.LibraryEntity;
import com.detay.libraryautomation.service.libraryService.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryController {

    LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a library.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A library has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Library not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public LibraryEntity getLibrary(@NotBlank @PathVariable("id") int id) {
        return libraryService.getLibrary(id);
    }

}
