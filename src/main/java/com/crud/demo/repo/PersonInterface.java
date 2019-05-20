package com.crud.demo.repo;

import java.util.Map;
import com.crud.demo.model.Person;

public interface PersonInterface {
	public void save(Person person);
	public Person find(Long id);
	public Map<Long, Person> findAll();
	public void update(Person person);
	public void delete(Long id);
}
