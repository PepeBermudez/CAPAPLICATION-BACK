package com.joseberm.capApplication;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer> {

	List<User> findAll();

	User save(User u);

	User findByUserid(int id);

	void delete(User u);
	
	void deleteById(int id);
	

}
