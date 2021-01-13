package br.com.hivecloud.msbookregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hivecloud.msbookregister.model.TargetBook;
import br.com.hivecloud.msbookregister.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation("Get Target Book By User")
	@GetMapping("{id}/target/{year}")
	public ResponseEntity<TargetBook> findTarget(@PathVariable Long id, @PathVariable int year) {

		TargetBook targetBook = service.findUserBookTarget(id, year);
		return ResponseEntity.ok(targetBook);
	}

}
