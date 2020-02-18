package com.joseberm.capApplication;

import java.util.List;

public interface UserService {

	List<User> userList();

	User listId(int id);

	User add(User u);

	User update(User u);

	void delete(int id);
	Boolean login (String userid, String pass);
	
	

}
