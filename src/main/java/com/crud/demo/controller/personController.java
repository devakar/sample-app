package com.crud.demo.controller;

import java.util.Map;

import com.crud.demo.model.Person;
import com.crud.demo.repo.PersonInterface;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/persons")
public class personController {
	private PersonInterface repository;

	@Autowired
	public personController(PersonInterface repository)
	{
		this.repository = repository;
	}
	
	@RequestMapping("/save")
	public String save() {
	    // save a single Customer
		repository.save(new Person(1, "Jack", "Smith", "js@gmail.com"));
		repository.save(new Person(2, "Adam", "Johnson", "aj@gmailcom"));
		repository.save(new Person(3, "Kim", "Smith", "ks@gmail.com"));
		repository.save(new Person(4, "David", "Williams", "dw@gmail.com"));
		repository.save(new Person(5, "Peter", "Davis", "pd@gmailcom"));
	 
	    return "Done";
	  }

	 @RequestMapping("/findall")
	 public String findAll() {
	    String result = "";
	    Map<Long, Person> persons = repository.findAll();
	 
	    for (Person person : persons.values()) {
	      result += person.toString() + "<br>";
	    }
	 
	    return result;
	  }
	 
	 @RequestMapping("/find")
	  public String findById(@RequestParam("id") Long id) {
	    String result = "";
	    result = repository.find(id).toString();
	    return result;
	  }
	 
	 @RequestMapping("/delete")
	  public String deleteById(@RequestParam("id") Long id) {
	    repository.delete(id);
	 
	    return "Done";
	  }
	 
}
