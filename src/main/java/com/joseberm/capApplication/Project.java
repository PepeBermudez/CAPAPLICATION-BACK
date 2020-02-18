package com.joseberm.capApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javassist.expr.NewArray;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false) 
	private int id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private LocalDate startdate;

	@Column
	private LocalDate enddate;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true )
	List<EmployeeProjectPeriod> epplist = new ArrayList<EmployeeProjectPeriod>();
	
	@ManyToMany
	@JoinTable(name = "project_skills",joinColumns = @JoinColumn(name = "idproject"),inverseJoinColumns = @JoinColumn(name = "idskill"))
	List<Skill> skills;

	
	public List<Skill> getSkills() {
		return skills;
	}


	
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public int getId() {
		return id;
	}

	
	public List<EmployeeProjectPeriod> getEpplist() {
		return epplist;
	}

	
	public void setEpplist(List<EmployeeProjectPeriod> epplist) {
		this.epplist = epplist;
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

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

}
