package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.model.Author;
import com.detay.libraryautomation.service.authorService.AuthorService;
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
@RequestMapping(value = "/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @Operation(summary = "Get a author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Author not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{authorId}")
    public Author getAuthor(@NotBlank @PathVariable("authorId") long authorId) {
        return authorService.getAuthor(authorId);
    }


    @Operation(summary = "Create new author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "New Author Created.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Author.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found.",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict. Author with id already exist.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/author")
    public Author createAuthor(@Valid AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
    }

    @Operation(summary = "Update author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been update.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "304", description = "Not Modified.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{authorId}")
    public Author updateAuthor(@NotBlank @PathVariable("authorId") long authorId, @Valid @RequestBody AuthorRequest authorRequest) {
        return authorService.updateAuthor(authorId, authorRequest);
    }

    @Operation(summary = "Delete author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been deleted.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Author not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete{authorId}")
    public void deleteAuthor(@PathVariable("authorId") long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @Operation(summary = "Get all authors.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All authors listed.",
                    content = {@Content(mediaType = "application/json")})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAuthors")
    public List<Author> getAll() {
        return authorService.getAll();
    }

}
