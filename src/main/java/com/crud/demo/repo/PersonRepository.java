package com.crud.demo.repo;



import java.util.Map;

import com.crud.demo.model.Person;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;


public class PersonRepository implements PersonInterface {
	public static final String PERSONS_KEY = "persons";

	private final HashOperations<String, Long, Person> hashOps;

	public PersonRepository(RedisTemplate<String, Person> redisTemplate) {
		this.hashOps = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Person person) {
		hashOps.put(PERSONS_KEY, person.getId(), person);
	}
	
	@Override
	public Person find(Long id) {
		return hashOps.get(PERSONS_KEY, id);
	}
	
	@Override
	public Map<Long, Person> findAll() {
	    return hashOps.entries(PERSONS_KEY);
	  }
	
	@Override
	public void update(Person person) {
	    hashOps.put(PERSONS_KEY, person.getId(), person);
	 }
	
	@Override
	  public void delete(Long id) {
	    hashOps.delete(PERSONS_KEY, id);
	  }
}
