package com.joseberm.capApplication;

import java.util.List;

public class ProjectEmployee {
	private String name; 
	private Project project; 
	private List<EmployeeProjectPeriod> epp;
	
	public ProjectEmployee(Project project, List<EmployeeProjectPeriod> epp) {
		this.name=project.getName();
		this.project=project;
		this.epp=epp;
	}

	
	public Project getProject() {
		return project;
	}

	
	public void setProject(Project project) {
		this.project = project;
	}

	
	public List<EmployeeProjectPeriod> getEpp() {
		return epp;
	}

	
	public void setEpp(List<EmployeeProjectPeriod> epp) {
		this.epp = epp;
	}
	

}
