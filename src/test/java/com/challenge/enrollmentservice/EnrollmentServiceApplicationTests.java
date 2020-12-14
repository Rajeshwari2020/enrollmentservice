package com.challenge.enrollmentservice;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.enrollmentservice.models.DependentEnrollee;
import com.challenge.enrollmentservice.models.Enrollee;
import com.challenge.enrollmentservice.repositories.EnrolleeRepository;
import com.challenge.enrollmentservice.services.EnrolleeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollmentServiceApplicationTests {

    @Autowired
    private EnrolleeService enrolleeService;
    @Autowired
    private EnrolleeRepository enrolleeRepository;

    @Test
    public void createEnrollee() {
        Enrollee enrollee = new Enrollee(1, "ABC", true, "11/01/1901", "500-222-11-11");
        Assert.assertTrue(enrolleeService.createEnrollee(enrollee));
        Optional<Enrollee> result = enrolleeRepository.findById((long) 1);
        Assert.assertEquals(enrollee.getId(), result.get().getId());
        Assert.assertEquals(enrollee.getName(), result.get().getName());
        Assert.assertEquals(enrollee.getPhoneNumber(), result.get().getPhoneNumber());
        Assert.assertEquals(enrollee.getBirthDay(), result.get().getBirthDay());
    }

    @Test
    public void modifyEnrollee() {
        Enrollee enrollee = new Enrollee(1, "ABC", true, "11/01/1901", "500-222-11-11");
        enrolleeService.createEnrollee(enrollee);
        Enrollee enrollee2 = new Enrollee(1, "KDR", false,"11/01/1902", "500-222-11-12");
        Assert.assertTrue(enrolleeService.modifyEnrollee(enrollee2));
        Optional<Enrollee> result = enrolleeRepository.findById((long) 1);
        Assert.assertEquals(enrollee2.getId(), result.get().getId());
        Assert.assertEquals(enrollee2.getName(), result.get().getName());
        Assert.assertEquals(enrollee2.getPhoneNumber(), result.get().getPhoneNumber());
        Assert.assertEquals(enrollee2.getBirthDay(), result.get().getBirthDay());
    }

    @Test
    public void removeEnrollee()
    {
        Enrollee enrollee = new Enrollee(1, "ABC", true, "11/01/1901", "500-222-11-11");
        enrolleeService.createEnrollee(enrollee);
        Assert.assertTrue(enrolleeService.removeEnrollee(1));
    }

    @Test
    public void addDependent()
    {
        Enrollee enrollee = new Enrollee(1, "ABC", true, "11/01/1901", "500-222-11-11");
        enrolleeService.createEnrollee(enrollee);
        DependentEnrollee dependentEnrollee = new DependentEnrollee(2, "CZT", "12/08/1999");
        Assert.assertFalse(enrolleeService.addDependent(1,dependentEnrollee));
    }

    @Test
    public void removeDependent()
    {
        Enrollee enrollee = new Enrollee(1, "ABC", true, "11/01/1901", "500-222-11-11");
        enrolleeService.createEnrollee(enrollee);
        DependentEnrollee dependentEnrollee = new DependentEnrollee(2, "CZT", "12/08/1999");
        enrolleeService.addDependent(1,dependentEnrollee);
        Assert.assertFalse(enrolleeService.removeDependent(1,2));
    }
}
