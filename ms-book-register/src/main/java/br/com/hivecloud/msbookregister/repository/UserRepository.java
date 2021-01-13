package br.com.hivecloud.msbookregister.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hivecloud.msbookregister.model.TargetBook;
import br.com.hivecloud.msbookregister.model.User;
import br.com.hivecloud.msbookregister.model.UserBook;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM TargetBook obj WHERE obj.user.id = :userId and obj.year = :year")
	Optional<TargetBook> findByBookTarget(@Param("userId") Long userId, @Param("year") int year);

	@Query("SELECT obj FROM UserBook obj WHERE obj.user.id = :id")
	Page<UserBook> findUserBooks(@Param("id") Long id, Pageable pageable);

}
