package br.com.hivecloud.msbookregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hivecloud.msbookregister.model.UserBook;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

}
