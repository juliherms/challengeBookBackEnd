package br.com.hivecloud.msbookregister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hivecloud.msbookregister.dto.BookDTO;
import br.com.hivecloud.msbookregister.mapper.BookMapper;
import br.com.hivecloud.msbookregister.model.Book;
import br.com.hivecloud.msbookregister.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class responsible to provide BOOKs endpoint
 * @author jlv
 *
 */
@RestController
@RequestMapping("/bookings")
@Api(tags = "Book")
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private BookMapper bookMapper;

	/**
	 * This methos responsible to create books in the application
	 * @param dto
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = "create books in the api", response = BookDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED") })
	public ResponseEntity<BookDTO> create(@RequestBody @Valid BookDTO dto) {

		Book b = bookMapper.toBookCreate(dto);
		Book bookCreated = service.create(b);
		BookDTO bookDTO = bookMapper.toBookDTO(bookCreated);

		return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
	}

}
