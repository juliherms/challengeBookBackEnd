package br.com.hivecloud.msbookregister.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hivecloud.msbookregister.model.Book;

/**
 * This class responsible to access book table
 * @author jlv
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findByName(String name);

	List<Book> findByYear(int year);

}
