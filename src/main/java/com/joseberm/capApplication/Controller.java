package com.joseberm.capApplication;

import java.sql.PseudoColumnUsage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capApplication")

public class Controller {

	/////////// USER

	@Autowired
	UserService service;

	@GetMapping(value = "/list")
	public List<User> listar() {
		return service.userList();
	}

	@GetMapping(value = "/{username}/{password}")
	public Boolean login(@PathVariable String username, @PathVariable String password) {
		return service.login(username, password);
	}

	@PostMapping(value = "/add")
	public User add(@RequestBody User u) {

		return service.add(u);

	}

	@GetMapping(value = "/login")
	public User login(@PathVariable User u) {

		List<User> userList = service.userList();

		for (User user : userList) {
			if (user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())) {
				 user.setLogged(true);
				 return user;

			}
		}
		return null;

	}

	@GetMapping(value = "/isLogged/{userid}")
	public Boolean isLogged(@PathVariable int userid) {

		User u = service.listId(userid);
		if (u.getLogged() == true) {
			return true;
		}
		return false;

	}

	@GetMapping(path = {"/{id}"})
	public User listarId(@PathVariable("id") int id) {
		return service.listId(id);
	}

	@GetMapping(path = {"getEmployee"})
	public List<Employee> getEmployee() {

		List<User> userList = service.userList();

		List<Employee> employeeList = new ArrayList<Employee>();

		for (User user : userList) {
			Employee e = new Employee();
			e = user.getEmployee();
			employeeList.add(e);
		}
		return employeeList;

	}

	@PutMapping(path = {"/{id}"})
	public User edit(@RequestBody User u, @PathVariable("id") int id) {
		u.setUserid(id);
		return service.update(u);
	}

	@DeleteMapping(path = {"/{id}"})
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	///////////// PROJECT

	@Autowired
	ProjectService projservice;

	@GetMapping(value = "/listprojects")
	public List<Project> listarProj() {
		return projservice.projectList();
	}

	@PostMapping(value = "/addprojects")
	public Project add(@RequestBody Project p) {
		p.setStartdate(LocalDate.now());
		p.setEnddate(LocalDate.now());

		return projservice.add(p);

	}

	@PostMapping(value = "/addprojects2")
	public Project add2(@RequestBody Project p, @RequestBody Skill s) {
		System.out.println(s.getName());

		return projservice.add(p);

	}

	@GetMapping(path = {"editProject/{id}"})
	public Project listarIdP(@PathVariable("id") int id) {
		return projservice.listId(id);
	}

	@GetMapping(path = {"getEPP/{id}"})
	public List<EmployeeProjectPeriod> getEPP(@PathVariable("id") int id) {
		Project project = projservice.listId(id);
		List<Project> pList = projservice.projectList();
		List<EmployeeProjectPeriod> epp = new ArrayList<EmployeeProjectPeriod>();
		for (Project p : pList) {
			if (project.getId() == p.getId()) {
				epp = p.getEpplist();
			}

		}
		return epp;

	}

	@GetMapping(path = {"getEPP2/{id}"})
	public List<Skill> getEPP2(@PathVariable("id") int id) {
		Project project = projservice.listId(id);
		List<Project> pList = projservice.projectList();
		List<Skill> sl = new ArrayList<Skill>();
		for (Project p : pList) {
			if (project.getId() == p.getId()) {
				sl = p.getSkills();
			}

		}
		return sl;

	}

	@PutMapping(path = {"editProject/{id}"})
	public Project editP(@RequestBody Project p, @PathVariable("id") int id) {
		p.setId(id);
		return projservice.update(p);
	}

	@DeleteMapping(path = {"project/{id}"})
	public void deleteP(@PathVariable("id") int id) {
		projservice.delte(id);
	}

	@PostMapping(path = {"addToProject/{idProject}/employee/{idEmployee}"})
	public void associateProjectEmployee(@PathVariable int idProject, @PathVariable int idEmployee) {
		Project pr = projservice.listId(idProject);

		List<EmployeeProjectPeriod> periodList = pr.getEpplist();

		EmployeeProjectPeriod newPeriod = new EmployeeProjectPeriod();

		newPeriod.id = idProject + idEmployee;
		newPeriod.idemployee = idEmployee;
		newPeriod.idproject = idProject;
		newPeriod.startdate = LocalDate.now();
		newPeriod.enddate = LocalDate.now();
		newPeriod.dedication = 100;

		periodList.add(newPeriod);

		pr.setEpplist(periodList);

		projservice.update(pr);

	}

	@PostMapping(path = {"listProjectEmployee"})
	public List<ProjectEmployee> listProjectEmployee() {

		List<Project> plist = projservice.projectList();
		List<EmployeeProjectPeriod> epp;
		List<ProjectEmployee> pelist = new ArrayList<ProjectEmployee>();
		for (Project p : plist) {
			epp = p.getEpplist();
			ProjectEmployee pe = new ProjectEmployee(p, epp);
			pelist.add(pe);
		}

		return pelist;

	}

	@PostMapping(path = {"addSkillToProject/{idProject}/skill/{id}"})
	public void associateProjectSkill(@PathVariable int idProject, @PathVariable int id) {

		Project pj = projservice.listId(idProject);

		List<Skill> sList = pj.getSkills();

		Skill skill = skillService.listId(id);

		sList.add(skill);

		pj.setSkills(sList);
		System.out.println(skill.getName());
		System.out.println(pj.getId());
		projservice.update(pj);

	}

	///////////// EMPLOYEE

	@Autowired
	EmployeeService emService;

	@GetMapping(value = "/listEmployees")
	public List<Employee> listarE() {
		return emService.EmployeeList();
	}

	@PostMapping(value = "/addemployee/{userid}")
	public Employee add(@PathVariable int userid) {

		Employee e = new Employee();

		e.setId(userid);
		e.setHiredate(LocalDate.now());

		return emService.add(e);

	}

	@GetMapping(path = {"getEmployeePP/{id}"})
	public List<EmployeeProjectPeriod> getEmployeePP(@PathVariable("id") int id) {
		Employee employee = emService.listId(id);
		List<Employee> eList = emService.EmployeeList();
		List<EmployeeProjectPeriod> epp = new ArrayList<EmployeeProjectPeriod>();
		for (Employee e : eList) {
			if (employee.getId() == e.getId()) {
				epp = e.getEpplist();
			}

		}
		return epp;

	}

	@GetMapping(path = {"getEmployeeSkills/{id}"})
	public List<Skill> getEmployeeSkills(@PathVariable("id") int id) {
		Employee employee = emService.listId(id);
		List<Employee> eList = emService.EmployeeList();
		List<Skill> sl = new ArrayList<Skill>();
		for (Employee e : eList) {
			if (employee.getId() == e.getId()) {
				sl = e.getSkilllist();
			}

		}
		return sl;

	}

	@GetMapping(path = {"listProject/{id}"})
	public Employee listarIdE(@PathVariable("id") int id) {
		return emService.listId(id);
	}

	@GetMapping(path = {"getEmployeeSkills"})
	public List<Skill> getEmployeeSkill() {

		List<Skill> sList = skillService.skillList();

		return sList;

	}

	@PutMapping(path = {"employee/{id}"})
	public Employee editE(@RequestBody Employee e, @PathVariable("id") int id) {
		e.setId(id);
		return emService.update(e);
	}

	@DeleteMapping(path = {"listEmployee/{id}"})
	public Employee deleteE(@PathVariable("employeeid") int id) {
		return emService.delte(id);
	}

	@PostMapping(path = {"addToEmployee/{idEmployee}/skill/{idSkill}"})
	public void associateSkillEmployee(@PathVariable int idSkill, @PathVariable int idEmployee) {

		Employee e = emService.listId(idEmployee);
		Skill s = skillService.listId(idSkill);

		List<Skill> skillList = e.getSkilllist();

		skillList.add(s);

		e.setSkilllist(skillList);

		emService.update(e);

	}

	/////////// SKILL

	@Autowired
	SkillService skillService;

	@GetMapping(value = "/listSkills")
	public List<Skill> listarS() {
		return skillService.skillList();
	}

	@PostMapping(value = "/addSkill")
	public Skill add(@RequestBody Skill s) {

		return skillService.add(s);

	}

	@GetMapping(path = {"/listSkill/{id}"})
	public Skill listarSkillId(@PathVariable("id") int id) {

		return skillService.listId(id);
	}

	@PutMapping(path = {"/editSkil/{id}"})
	public Skill editSkill(@RequestBody Skill s, @PathVariable("id") int id) {

		return skillService.update(s);
	}

	@DeleteMapping(path = {"/deleteSkill/{id}"})
	public void deleteSkill(@PathVariable("id") int id) {
		skillService.delete(id);
	}

}
