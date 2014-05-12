package com.company.test;

import com.company.domain.Person;
import com.company.test_api.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */


@RunWith(JUnit4.class)
public class PersonTest {
    Person person;

    @Before
    public void setUp() throws Exception {

        person = new Person();
        person.setEmail("shovonis@yahoo.com");
        person.setName("Rifatul");
        person.setAge(1000000);
    }

    @After
    public void tearDown() throws Exception {
        person = null;
    }

    @Test
    public void testEmail() throws Exception {
        boolean isEmail = Validator.emailValidator(person);
        Assert.assertEquals("Email is validated : ", true, isEmail);
    }

    @Test
    public void testName() throws Exception {
        boolean isNameCorrect = Validator.nameValidator(person);
        Assert.assertEquals("Name ", true, isNameCorrect);
    }

    @Test
    public void testAge() throws Exception {
        boolean isAgeValid = Validator.ageValidator(person);
        Assert.assertEquals("Age ", true, isAgeValid);
    }
}