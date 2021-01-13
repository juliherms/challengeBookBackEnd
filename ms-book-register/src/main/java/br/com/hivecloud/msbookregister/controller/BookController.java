package br.com.hivecloud.msbookregister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hivecloud.msbookregister.dto.BookDTO;
import br.com.hivecloud.msbookregister.mapper.BookMapper;
import br.com.hivecloud.msbookregister.model.Book;
import br.com.hivecloud.msbookregister.model.Comment;
import br.com.hivecloud.msbookregister.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class responsible to provide BOOKs endpoint
 * 
 * @author jlv
 *
 */
@RestController
@RequestMapping("/books")
@Api(tags = "Book")
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private BookMapper bookMapper;

	/**
	 * This method responsible to create books in the application
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = "create books", response = BookDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED") })
	public ResponseEntity<BookDTO> create(@RequestBody @Valid BookDTO dto) {

		Book b = bookMapper.toBookCreate(dto);
		Book bookCreated = service.create(b);
		BookDTO bookDTO = bookMapper.toBookDTO(bookCreated);

		return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
	}

	/**
	 * This method responsible to list all books in the application
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	@ApiOperation("find all books")
	public ResponseEntity<Page<BookDTO>> list(Pageable pageable) {

		Page<Book> bookList = service.findAll(pageable);
		Page<BookDTO> result = bookMapper.converterPageEntityToDto(bookList);

		return ResponseEntity.ok(result);
	}

	@ApiOperation("find all comments by book")
	@GetMapping("{id}/comments")
	public ResponseEntity<Page<Comment>> listComments(@PathVariable Long id, Pageable pageable) {

		Page<Comment> commentsList = service.findCommentsByBook(id, pageable);
		return ResponseEntity.ok(commentsList);
	}

	/**
	 * This method responsible to list books by title
	 * 
	 * @param title
	 * @param pageable
	 * @return
	 */
	@GetMapping("filter")
	@ApiOperation("Find all books by title")
	public ResponseEntity<Page<BookDTO>> list(@RequestParam(value = "title", defaultValue = "") String title,
			Pageable pageable) {

		Page<Book> bookList = service.findByTitle(title, pageable);
		Page<BookDTO> result = bookMapper.converterPageEntityToDto(bookList);

		return ResponseEntity.ok(result);
	}

}
