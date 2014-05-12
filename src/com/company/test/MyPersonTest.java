package com.company.test;

import com.company.annotation.TestCase;
import com.company.annotation.TestClass;
import com.company.domain.Person;
import com.company.test_api.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */

@TestClass
public class MyPersonTest {

    @TestCase
    public void testEmail() {
        Validator validator = new Validator();
        Person person = new Person();

        person.setEmail("shovonis@yahoo.com");
        validator.emailValidator(person);
    }

    @TestCase
    public  void nullTest(){

    }
}
