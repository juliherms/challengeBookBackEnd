package br.com.hivecloud.msbookregister.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hivecloud.msbookregister.model.Book;
import br.com.hivecloud.msbookregister.model.Comment;

/**
 * This class responsible to access book table
 * 
 * @author jlv
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findByTitle(String title);

	List<Book> findByYear(int year);

	@Query("SELECT obj FROM Book obj WHERE obj.title LIKE %:title%")
	Page<Book> findByTitleLike(@Param("title") String title, Pageable pageable);
	
	@Query("SELECT obj FROM Comment obj WHERE obj.book.id = :bookId")
	Page<Comment> findCommentsByBook(@Param("bookId") Long bookId, Pageable pageable);

}
