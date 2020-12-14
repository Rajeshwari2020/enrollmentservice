package com.challenge.enrollmentservice.services;

import com.challenge.enrollmentservice.models.DependentEnrollee;
import com.challenge.enrollmentservice.models.Enrollee;
import com.challenge.enrollmentservice.repositories.DependentRepository;
import com.challenge.enrollmentservice.repositories.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

    @Autowired
    private EnrolleeRepository enrolleeRepository;
    
    @Autowired
    private DependentRepository dependentRepository;

    public void setEnrolleeRepository(EnrolleeRepository enrolleeRepository)
    {
        this.enrolleeRepository = enrolleeRepository;
    }

    @Override
    public boolean createEnrollee(Enrollee enrollee) {
        try
        {
            Enrollee person = new Enrollee(enrollee.getId(), enrollee.getName(), enrollee.getActivationStatus(),enrollee.getBirthDay(), enrollee.getPhoneNumber());
            enrolleeRepository.save(person);
            return true;
        }catch (Exception e)
        {
            return false;
        }

    }
    @Override
    public List<Enrollee> getEnrollees()
    {
        return enrolleeRepository.findAll();
    }

    @Override
    public boolean modifyEnrollee(Enrollee enrollee) {
        try
        {
            Optional<Enrollee> record = enrolleeRepository.findById(enrollee.getId());
            Enrollee newRecord = new Enrollee();
            newRecord.setId(enrollee.getId());

            if(enrollee.getBirthDay()!= null)
                newRecord.setBirthDay(enrollee.getBirthDay());
            else
                record.ifPresent(value -> newRecord.setBirthDay(value.getBirthDay()));

            if(enrollee.getName() != null)
                newRecord.setName(enrollee.getName());
            else
                record.ifPresent(value -> newRecord.setName(value.getName()));

            if(enrollee.getPhoneNumber() != null)
                newRecord.setPhoneNumber(enrollee.getPhoneNumber());
            else
                record.ifPresent(value -> newRecord.setPhoneNumber(value.getPhoneNumber()));

            newRecord.setActivationStatus(enrollee.getActivationStatus());

            enrolleeRepository.deleteById(enrollee.getId());
            enrolleeRepository.save(newRecord);
            return true;
        }catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean removeEnrollee(long id) {
        try{
            enrolleeRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean addDependent(long enrolleeID, DependentEnrollee dependentEnrollee) {

        try{
            Optional<Enrollee> record = enrolleeRepository.findById(enrolleeID);
            record.get().getDependentEnrolleeList().add(dependentEnrollee);
            dependentEnrollee.setEnrollee(record.get());

            dependentRepository.save(dependentEnrollee);
            return true;
        }catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean removeDependent(long enrolleeID, long dependentID) {
        try
        {
            Optional<DependentEnrollee> dependentEnrollee = dependentRepository.findById(dependentID);
            dependentRepository.delete(dependentEnrollee.get());

            Optional<Enrollee> record = enrolleeRepository.findById(enrolleeID);
            record.get().getDependentEnrolleeList().remove(dependentEnrollee);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}
