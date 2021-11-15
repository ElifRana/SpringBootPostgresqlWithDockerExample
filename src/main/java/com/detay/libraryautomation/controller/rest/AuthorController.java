package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.dto.AuthorRequest;
import com.detay.libraryautomation.model.AuthorEntity;
import com.detay.libraryautomation.service.authorService.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{authorId}")
    @Operation(summary = "Get a author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Author not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public AuthorEntity getAuthor(@NotBlank @PathVariable("authorId") int authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping("/author")
    @Operation(summary = "Create new author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "New Author Created.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorEntity.class))}),
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
    public AuthorEntity createAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
    }

    @PutMapping("/{authorId}")
    @Operation(summary = "Update author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been update.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "304", description = "Not Modified.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public AuthorEntity updateAuthor(@NotBlank @PathVariable("authorId") int authorId, AuthorRequest authorRequest) {
        return authorService.updateAuthor(authorId, authorRequest);
    }

    @DeleteMapping("/delete{authorId}")
    @Operation(summary = "Delete author.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A author has been deleted.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Author not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("authorId") int authorId) {
        authorService.deleteAuthor(authorId);
    }

    @GetMapping("/getAuthors")
    @Operation(summary = "Get all authors.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All authors listed.",
                    content = {@Content(mediaType = "application/json")})
    })
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorEntity> getAll() {
        return authorService.getAll();
    }
}
