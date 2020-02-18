package com.joseberm.capApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectRepository repository;

	@Override
	public List<Project> projectList() {

		return repository.findAll();
	}

	@Override
	public Project listId(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Project add(Project p) {
		
		return repository.save(p);
	}

	@Override
	public Project update(Project p) {
		
		return repository.save(p);
	}

	@Override
	public void delte(int id) {
		Project p=repository.findById(id);
		if (p!=null) {
			repository.delete(p);
		}
		
		
	}

}
