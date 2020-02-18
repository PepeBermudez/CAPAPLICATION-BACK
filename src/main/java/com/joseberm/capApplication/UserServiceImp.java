package com.joseberm.capApplication;

import java.util.List;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> userList() {

		return repository.findAll();
	}

	@Override
	public User add(User u) {
		return repository.save(u);

	}

	@Override
	public User update(User u) {

		return repository.save(u);
	}

	@Override
	public void delete(int id) {

		repository.deleteById(id);

		/*
		 * User u=repository.findByUserid(id);
		 * if (u!=null) {
		 * repository.delete(u);
		 * }
		 */

	}

	@Override
	public User listId(int id) {

		return repository.findByUserid(id);
	}

	@Override
	public Boolean login(String username, String pass) {
		List<User> users;
		
		users = repository.findAll();
		
		for(User u:users) {
			if(u.getFirstname().equals(username) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		
		return null;
	}

}
