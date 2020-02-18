package com.joseberm.capApplication;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface SkillRepository extends Repository<Skill, Integer>{
	
	List<Skill> findAll();

	Skill save(Skill s);

	Skill findById(int id);

	void delete(Skill s);
}
