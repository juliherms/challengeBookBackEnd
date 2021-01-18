package br.com.hivecloud.msbookregister.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.hivecloud.msbookregister.dto.BookUserDTO;
import br.com.hivecloud.msbookregister.model.UserBook;
import br.com.hivecloud.msbookregister.service.BookService;
import br.com.hivecloud.msbookregister.service.UserService;

@Component
public class BookUserMapper  {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public UserBook toUserBookCreate(BookUserDTO dto) {
		
		UserBook userBook = new UserBook();
		userBook.setDescription(dto.getDescription());
		userBook.setLevel(dto.getLevel());
		userBook.setStatus(dto.getStatus());
		userBook.setTitle(dto.getTitle());
		
		if(dto.getIdUser() > 0) {
			userBook.setUser(userService.findById(dto.getIdUser()));
		}
		
		if(dto.getIdUser() > 0) {
			userBook.setBook(bookService.findById(dto.getIdBook()));
		}
		
		return userBook;
	}

	public UserBook toBook(BookUserDTO dto) {
		return MODEL_MAPPER.map(dto, UserBook.class);
	}

	public BookUserDTO toUserBookDTO(UserBook userBook) {
		return MODEL_MAPPER.map(userBook, BookUserDTO.class);
	}

	public List<BookUserDTO> toBookDTOList(List<UserBook> bookList) {
		return bookList.stream().map(this::toUserBookDTO).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public Page<BookUserDTO> converterPageEntityToDto(Page<UserBook> userBook) {
		return MODEL_MAPPER.map(userBook, Page.class);
	}

}