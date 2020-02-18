package com.joseberm.capApplication;

import java.util.List;

public interface EmployeeService {

	List<Employee> EmployeeList();
	
	Employee listId(int id);

	Employee add(Employee e);

	Employee update(Employee e);

	Employee delte(int id);
	
}
