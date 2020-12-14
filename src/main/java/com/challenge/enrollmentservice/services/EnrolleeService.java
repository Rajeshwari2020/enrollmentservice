package com.challenge.enrollmentservice.services;

import com.challenge.enrollmentservice.models.DependentEnrollee;
import com.challenge.enrollmentservice.models.Enrollee;

import java.util.List;

public interface EnrolleeService {
    public boolean createEnrollee(Enrollee enrollee);
    public boolean modifyEnrollee(Enrollee enrollee);
    public boolean removeEnrollee(long id);
    public boolean addDependent(long enrolleeID, DependentEnrollee dependentEnrollee);
    public boolean removeDependent(long enrolleeID, long dependentID);
    public List<Enrollee> getEnrollees();
}
