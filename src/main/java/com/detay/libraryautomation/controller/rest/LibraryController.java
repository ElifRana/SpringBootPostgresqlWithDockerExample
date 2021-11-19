package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.dto.LibraryRequest;
import com.detay.libraryautomation.model.Author;
import com.detay.libraryautomation.model.Library;
import com.detay.libraryautomation.service.libraryService.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @Operation(summary = "Get a library.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A library has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Library not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{libraryId}")
    public Library getLibrary(@NotBlank @PathVariable("libraryId") long libraryId) {
        return libraryService.getLibrary(libraryId);
    }

    @Operation(summary = "Create new library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "New Library Created.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Author.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found.",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict. Library with id already exist.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.",
                    content = @Content)
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(name = "/library")
    public Library createLibrary(@Valid @RequestBody LibraryRequest libraryRequest) {

        return libraryService.createLibrary(libraryRequest);
    }

    @Operation(summary = "Update library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A library has been update.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "304", description = "Not Modified.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{libraryId}")
    public Library updateLibrary(@NotBlank @PathVariable("libraryId") Long libraryId, @Valid @RequestBody LibraryRequest libraryRequest) {
        return libraryService.updateLibrary(libraryId, libraryRequest);
    }

    @Operation(summary = "Delete library.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A library has been deleted.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Library not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete{libraryId}")
    public void deleteLibrary(@PathVariable("libraryId") Long libraryId) {
        libraryService.deleteLibrary(libraryId);
    }

    @Operation(summary = "Get all libraries.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All libraries listed.",
                    content = {@Content(mediaType = "application/json")})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getLibraries")
    public List<Library> getAll() {
        return libraryService.getAll();
    }

}
