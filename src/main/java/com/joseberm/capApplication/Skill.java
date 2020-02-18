package com.joseberm.capApplication;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false) 
	private int id;
	
	@Column
	private String name;

	@Column
	private String description;
	
	@ManyToMany(mappedBy = "skilllist")
	List<Employee> employees;

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	@JsonProperty(value="employees")
	public List<Employee> getEmployees() {
		return employees;
	}

	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
