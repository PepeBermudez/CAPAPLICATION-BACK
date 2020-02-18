package com.joseberm.capApplication;

import java.util.List;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImp implements SkillService{
	@Autowired
	private SkillRepository repository;
	@Override
	public List<Skill> skillList() {
		
		return repository.findAll();
	}

	@Override
	public Skill listId(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Skill add(Skill s) {
		
		return repository.save(s);
	}

	@Override
	public Skill update(Skill s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	}


