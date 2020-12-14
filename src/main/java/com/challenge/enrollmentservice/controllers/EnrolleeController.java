package com.challenge.enrollmentservice.controllers;

import com.challenge.enrollmentservice.models.DependentEnrollee;
import com.challenge.enrollmentservice.services.EnrolleeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.challenge.enrollmentservice.models.Enrollee;

import java.util.List;

@EnableSwagger2
@RestController
public class EnrolleeController {

	@Autowired
	private EnrolleeService enrolleeService;

	public void EnrolleeService(EnrolleeService enrolleeService)
	{
		this.enrolleeService = enrolleeService;
	}

	@PostMapping("/api/enrollee/create")
	public void saveEnrollee(@RequestBody long id, String name, boolean activationStatus, String birthDay, String phoneNumber)
	{
		Enrollee enrollee = new Enrollee(id, name, activationStatus, birthDay, phoneNumber);
		enrolleeService.createEnrollee(enrollee);
	}

	@GetMapping("/api/enrollee/get")
	public List<Enrollee> getEnrollees()
	{
		return enrolleeService.getEnrollees();
	}

	@PutMapping("/api/enrollee/modify")
	public void modifyEnrollee(long id, String name, boolean activationStatus, String birthDay, String phoneNumber)
	{
		Enrollee enrollee = new Enrollee(id, name, activationStatus, birthDay, phoneNumber);
		enrolleeService.modifyEnrollee(enrollee);
	}

	@DeleteMapping("/api/enrollee/remove")
	public void removeEnrollee(long id)
	{
		enrolleeService.removeEnrollee(id);
	}

	@PostMapping("/api/enrollee/dependent/add")
	public void addDependent(long enrolleeID, DependentEnrollee dependentEnrollee)
	{
		enrolleeService.addDependent(enrolleeID, dependentEnrollee);
	}

	@DeleteMapping("/api/enrollee/dependent/remove")
	public void removeDependent(long enrolleeID, long dependentID)
	{
		enrolleeService.removeDependent(enrolleeID, dependentID);
	}
}

