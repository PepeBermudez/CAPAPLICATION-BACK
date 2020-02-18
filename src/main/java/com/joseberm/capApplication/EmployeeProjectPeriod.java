package com.joseberm.capApplication;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employeeprojectperiod")
public class EmployeeProjectPeriod {

	@Id
	@Column
	int id;

	@Column
	int idemployee;

	@Column
	int idproject;

	@Column
	LocalDate startdate;

	@Column
	LocalDate enddate;

	@Column
	int dedication;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idemployee", referencedColumnName = "id", insertable = false, updatable = false)
	Employee employee;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idproject", referencedColumnName = "id", insertable = false, updatable = false)
	Project project;

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public int getIdemployee() {
		return idemployee;
	}

	
	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	
	public int getIdproject() {
		return idproject;
	}

	
	public void setIdproject(int idproject) {
		this.idproject = idproject;
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

	
	public int getDedication() {
		return dedication;
	}

	
	public void setDedication(int dedication) {
		this.dedication = dedication;
	}

	
	
	

}
