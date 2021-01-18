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
import org.springframework.web.bind.annotation.RestController;

import br.com.hivecloud.msbookregister.dto.BookDTO;
import br.com.hivecloud.msbookregister.dto.BookUserDTO;
import br.com.hivecloud.msbookregister.mapper.BookMapper;
import br.com.hivecloud.msbookregister.mapper.BookUserMapper;
import br.com.hivecloud.msbookregister.model.Book;
import br.com.hivecloud.msbookregister.model.TargetBook;
import br.com.hivecloud.msbookregister.model.UserBook;
import br.com.hivecloud.msbookregister.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private BookUserMapper bookUserMapper;


	@ApiOperation("Get Target Book By User")
	@GetMapping("{id}/target/{year}")
	public ResponseEntity<TargetBook> findTarget(@PathVariable Long id, @PathVariable int year) {

		TargetBook targetBook = service.findUserBookTarget(id, year);
		return ResponseEntity.ok(targetBook);
	}

	@ApiOperation("Get Books By User")
	@GetMapping("{id}/books")
	public ResponseEntity<Page<UserBook>> findBooks(@PathVariable Long id, Pageable pageable) {

		Page<UserBook> list = service.findUserBooks(id, pageable);
		return ResponseEntity.ok(list);
	}
	
	/**
	 * This method responsible to create books in the application
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping("/books")
	@ApiOperation(value = "add book for user", response = BookUserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED") })
	public ResponseEntity<UserBook> create(@RequestBody @Valid BookUserDTO dto) {

		UserBook userBook =  bookUserMapper.toUserBookCreate(dto);
	
		service.save(userBook);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userBook);
	}

	
	

}
