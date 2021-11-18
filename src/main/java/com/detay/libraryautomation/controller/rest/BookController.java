package com.detay.libraryautomation.controller.rest;

import com.detay.libraryautomation.dto.BookRequest;
import com.detay.libraryautomation.model.Book;
import com.detay.libraryautomation.repository.BookRepository;
import com.detay.libraryautomation.service.bookService.BookService;
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
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private BookRepository bookRepository;

    @Operation(summary = "Get a book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been brought in.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Book not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{bookId}")
    public Book getBook(@NotBlank @PathVariable("bookId") long bookId) {
        return bookService.getBook(bookId);
    }

    @Operation(summary = "Create new book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "New Book Created.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
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
    @PostMapping("/book")
    public Book createBook(@NotBlank @PathVariable("bookId") long bookId,@Valid @RequestBody BookRequest bookRequest) {
        return bookService.createBook(bookId, bookRequest);
    }

    @Operation(summary = "Update book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been update.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "304", description = "Not Modified.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{bookId}")
    public Book updateBook(@NotBlank @PathVariable("bookId") long bookId, BookRequest bookRequest) {
        return bookService.updateBook(bookId, bookRequest);
    }

    @Operation(summary = "Delete book.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A book has been deleted.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Book not found.",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete{bookId}")
    public void deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
    }

    @Operation(summary = "Get all books.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All books listed.",
                    content = {@Content(mediaType = "application/json")})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getBooks")
    public List<Book> getAll() {
        return bookService.getAll();
    }


}
