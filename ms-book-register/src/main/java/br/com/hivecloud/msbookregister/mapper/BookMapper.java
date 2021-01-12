package br.com.hivecloud.msbookregister.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.hivecloud.msbookregister.dto.BookDTO;
import br.com.hivecloud.msbookregister.model.Book;

/**
 * This class responsible to convert BOOK to DTO (Data Transfer Object)
 * @author jlv
 *
 */
@Component
public class BookMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public Book toBookCreate(BookDTO dto) {
		return MODEL_MAPPER.map(dto, Book.class);
	}

	public Book toBook(BookDTO dto) {
		return MODEL_MAPPER.map(dto, Book.class);
	}

	public BookDTO toBookDTO(Book book) {
		return MODEL_MAPPER.map(book, BookDTO.class);
	}

	public List<BookDTO> toBookDTOList(List<Book> bookList) {
		return bookList.stream().map(this::toBookDTO).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public Page<BookDTO> converterPageEntityToDto(Page<Book> book) {
		return MODEL_MAPPER.map(book, Page.class);
	}

}