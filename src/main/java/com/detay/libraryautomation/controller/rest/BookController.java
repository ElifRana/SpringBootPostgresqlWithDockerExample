package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.model.BookEntity;
import com.detay.libraryautomation.service.bookService.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    @Operation(summary = "Get a book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Book not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public BookEntity getBook(@NotBlank @PathVariable("bookId") int bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/book")
    @Operation(summary = "Create new book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "New Book Created.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found.",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict. Book with id already exist.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity createBook(@Valid @RequestBody BookRequest bookRequest) {
        return bookService.createBook(bookRequest);
    }

    @PutMapping("/{bookId}")
    @Operation(summary = "Update book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been update.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "304", description = "Not Modified.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public BookEntity updateBook(@NotBlank @PathVariable("bookId") int bookId, BookRequest bookRequest) {
        return bookService.updateBook(bookId, bookRequest);
    }

    @DeleteMapping("/delete{bookId}")
    @Operation(summary = "Delete book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been deleted.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Book not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/getBooks")
    @Operation(summary = "Get all books.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All books listed.",
                    content = {@Content(mediaType = "application/json")})
    })
    @ResponseStatus(HttpStatus.OK)
    public List<BookEntity> getAll() {
        return bookService.getAll();
    }

}
