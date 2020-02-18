package com.joseberm.capApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> EmployeeList() {
		
		return repository.findAll();
	}

	@Override
	public Employee listId(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	@Override
	public Employee delte(int id) {
		Employee e=repository.findById(id);
		if (e!=null) {}
		repository.delete(e);
		return e;
	}
	

}
