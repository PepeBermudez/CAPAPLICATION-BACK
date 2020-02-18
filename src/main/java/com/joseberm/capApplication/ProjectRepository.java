package com.joseberm.capApplication;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface ProjectRepository extends Repository<Project, Integer> {

	List<Project> findAll();
	Project save (Project u);
	Project findById (int id);
	void delete(Project u);
}
