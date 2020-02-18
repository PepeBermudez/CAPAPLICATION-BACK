package com.joseberm.capApplication;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, String> {

	List<Employee> findAll();

	Employee save(Employee e);

	Employee findById(int id);

	void delete(Employee e);
}
