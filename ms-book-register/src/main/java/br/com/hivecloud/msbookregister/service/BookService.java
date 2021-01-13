package br.com.hivecloud.msbookregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hivecloud.msbookregister.model.Book;
import br.com.hivecloud.msbookregister.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<Book> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<Book> findByTitle(String title, Pageable pageable) {
		return repo.findByTitleLike(title, pageable);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Book> findByYear(int year) {
		return repo.findByYear(year);
	}

	@Transactional
	public Book create(Book book) {
		repo.save(book);
		return book;
	}

}
