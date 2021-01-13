package br.com.hivecloud.msbookregister.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hivecloud.msbookregister.model.Book;

/**
 * Class responsible to test ParkingRepository
 * 
 * @author jlv
 *
 */
@DataJpaTest
@DisplayName("Tests for Book Repository")
public class BookRepositoryTest {

	@Autowired
	private BookRepository repo;

	private Book createBook() {

		Book b = new Book();
		b.setAuthor("Author Test");
		b.setTitle("Title Test");
		b.setYear(2020);

		return b;

	}

	@Test
	@DisplayName("save create parking when successful")
	public void savePersistBookWhenSuccessful() {

		Book b = createBook();
		Book savedBook = this.repo.save(b);

		Assertions.assertThat(savedBook).isNotNull();
		Assertions.assertThat(savedBook.getId()).isNotNull();
	}

}
