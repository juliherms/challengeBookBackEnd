package br.com.hivecloud.msbookregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hivecloud.msbookregister.model.TargetBook;
import br.com.hivecloud.msbookregister.model.UserBook;
import br.com.hivecloud.msbookregister.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public TargetBook findUserBookTarget(Long userId, int year) {
		Optional<TargetBook> optional = repo.findByBookTarget(userId, year);
		return optional.get();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<UserBook> findUserBooks(Long userId, Pageable pageable) {
		return repo.findUserBooks(userId, pageable);
	}
}
