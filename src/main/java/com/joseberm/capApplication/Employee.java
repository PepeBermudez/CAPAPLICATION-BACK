package com.joseberm.capApplication;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

	@Id	
	@Column
	private int id;

	@Column
	private LocalDate hiredate;

	
	public List<Skill> getSkilllist() {
		return skilllist;
	}

	public void setSkilllist(List<Skill> skilllist) {
		this.skilllist = skilllist;
	}

	@OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@MapsId("id")
	@JoinColumn(name = "id", nullable = false)
	User user;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true )
	List<EmployeeProjectPeriod> epplist;
	
	
	@ManyToMany
	@JoinTable(name = "employee_skills", joinColumns = @JoinColumn(name = "idemployee"), inverseJoinColumns = @JoinColumn(name = "idskill")) 
	List<Skill> skilllist;

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

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

}
