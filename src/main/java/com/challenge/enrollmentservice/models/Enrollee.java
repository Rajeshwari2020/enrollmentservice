package com.challenge.enrollmentservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "enrollee")
public class Enrollee {

	@Id
	private long id;
	private String name;
	private boolean activationStatus;
	private String birthDay;
	private String phoneNumber;

	@OneToMany
	private List<DependentEnrollee> dependentEnrolleeList;

	public Enrollee ()
	{

	}

	public Enrollee(long id, String name, boolean activationStatus, String birthDay, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.activationStatus = activationStatus;
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActivation_Status() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public boolean getActivationStatus() {
		return activationStatus;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<DependentEnrollee> getDependentEnrolleeList(){return dependentEnrolleeList;}
}
