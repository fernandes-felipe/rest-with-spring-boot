package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookServices service;
	
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Finds all Book",
			description = "Finds all Book",
			tags = {"Book"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = {
								@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
								)
							}),
					@ApiResponse(
							description = "Bad Request",
							responseCode = "400",
							content = {@Content}),
					@ApiResponse(
							description = "Unauthorized",
							responseCode = "401",
							content = {@Content}),
					@ApiResponse(
							description = "Not Found",
							responseCode = "404",
							content = {@Content}),
					@ApiResponse(
							description = "Internal Error",
							responseCode = "500",
							content = {@Content})
			}
		)
	public List<BookVO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	@Operation(
			summary = "Finds a Book",
			description = "Finds all Book",
			tags = {"Book"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(schema = @Schema(implementation = BookVO.class))
					),
					@ApiResponse(
							description = "No Content",
							responseCode = "204",
							content = {@Content}),
					@ApiResponse(
							description = "Bad Request",
							responseCode = "400",
							content = {@Content}),
					@ApiResponse(
							description = "Unauthorized",
							responseCode = "401",
							content = {@Content}),
					@ApiResponse(
							description = "Not Found",
							responseCode = "404",
							content = {@Content}),
					@ApiResponse(
							description = "Internal Error",
							responseCode = "500",
							content = {@Content})
			}
		)
	public BookVO findById(@PathVariable Long id) {
		return service.findbyId(id);
	}
	
	@PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Adds a new Book",
			description = "Adds a new Book by passing in a JSON in to body",
			tags = {"Book"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(schema = @Schema(implementation = BookVO.class))
					),
					@ApiResponse(
							description = "Bad Request",
							responseCode = "400",
							content = {@Content}),
					@ApiResponse(
							description = "Unauthorized",
							responseCode = "401",
							content = {@Content}),
					@ApiResponse(
							description = "Internal Error",
							responseCode = "500",
							content = {@Content})
			}
		)
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	
	@PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@Operation(
		summary = "Update a Book",
		description = "Update a Book by passing in a JSON in to body",
		tags = {"Book"},
		responses = {
				@ApiResponse(
						description = "Updated",
						responseCode = "200",
						content = @Content(schema = @Schema(implementation = BookVO.class))
				),
				@ApiResponse(
						description = "Bad Request",
						responseCode = "400",
						content = {@Content}),
				@ApiResponse(
						description = "Unauthorized",
						responseCode = "401",
						content = {@Content}),
				@ApiResponse(
						description = "Not Found",
						responseCode = "404",
						content = {@Content}),
				@ApiResponse(
						description = "Internal Error",
						responseCode = "500",
						content = {@Content})
		}
	)
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(
			summary = "Delete a Book",
			description = "Delete a Book by passing id in to url",
			tags = {"Book"},
			responses = {
					@ApiResponse(
							description = "No Content",
							responseCode = "204",
							content = @Content),
					@ApiResponse(
							description = "Bad Request",
							responseCode = "400",
							content = {@Content}),
					@ApiResponse(
							description = "Unauthorized",
							responseCode = "401",
							content = {@Content}),
					@ApiResponse(
							description = "Not Found",
							responseCode = "404",
							content = {@Content}),
					@ApiResponse(
							description = "Internal Error",
							responseCode = "500",
							content = {@Content})
			}
		)
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
