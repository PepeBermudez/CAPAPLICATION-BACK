package com.joseberm.capApplication;

import java.util.List;

public interface SkillService {

	List<Skill> skillList();

	Skill listId(int id);

	Skill add(Skill s);

	Skill update(Skill s);

	void delete(int id);

}
