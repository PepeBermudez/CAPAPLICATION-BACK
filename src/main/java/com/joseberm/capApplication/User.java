package com.joseberm.capApplication;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", updatable = false, nullable = false) 
	private int userid;

	@Column
	private String firstname;

	@Column
	private String lastname;

	
	public Boolean getLogged() {
		return logged;
	}

	
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

	@Column
	private String email;

	@Column
	private String password;
	
	@Column
	private Boolean logged;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
