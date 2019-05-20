package com.crud.demo.model;

public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private String emailAddress;

	public Person() {
	}

	public Person(long id, String firstName, String lastName, String emailAddress) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + "]";
	}
}
