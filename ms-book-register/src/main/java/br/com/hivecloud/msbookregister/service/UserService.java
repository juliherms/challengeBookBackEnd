package br.com.hivecloud.msbookregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hivecloud.msbookregister.exception.NotFoundException;
import br.com.hivecloud.msbookregister.model.TargetBook;
import br.com.hivecloud.msbookregister.model.User;
import br.com.hivecloud.msbookregister.model.UserBook;
import br.com.hivecloud.msbookregister.repository.UserBookRepository;
import br.com.hivecloud.msbookregister.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserBookRepository userBookRepository;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findById(Long id) {
		
		User user = repo.findById(id).orElseThrow(() -> 
		new NotFoundException(String.format("ID do usuario não encontrado: %s ",id.toString())) 
		);
		
		return user;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public TargetBook findUserBookTarget(Long userId, int year) {
		
		TargetBook targetBook = repo.findByBookTarget(userId, year).orElseThrow(() ->
			new NotFoundException(String.format("Não foi encontrado registro com os parâmetros informados: %s ",userId.toString()))
		);
		
		return targetBook;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<UserBook> findUserBooks(Long userId, Pageable pageable) {
		return repo.findUserBooks(userId, pageable);
	}
	
	@Transactional
	public void save(UserBook userBook) {
		userBookRepository.save(userBook);
	}
}
