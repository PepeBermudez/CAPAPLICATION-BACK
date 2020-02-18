package com.joseberm.capApplication;

import java.util.List;

public interface ProjectService {

	List<Project> projectList();

	Project listId(int id);

	Project add(Project p);

	Project update(Project p);

	void delte(int id);

}
