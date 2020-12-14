package com.challenge.enrollmentservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dependent_enrollee")
public class DependentEnrollee {

	@Id
	private long id;
	private String name;
	private String birthDay;

	@ManyToOne
	private Enrollee enrollee;

	public DependentEnrollee() {
		
	}
	
	public DependentEnrollee(long id, String name, String birthDay) {
		this.name = name;
		this.id = id;
		this.birthDay = birthDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthdate) {
		this.birthDay = birthdate;
	}

	public void setEnrollee(Enrollee enrollee) {this.enrollee = enrollee;}

}
