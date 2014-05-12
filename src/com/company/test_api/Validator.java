package com.company.test_api;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Validator {


    public static void setUpValidator(Object object) {

    }

    public static boolean emailValidator(Object object) {
        TestExecutor testExecutor = new TestExecutor();
        EmailValidator emailValidator = new EmailValidator(object);
        testExecutor.addTest(emailValidator);
        return testExecutor.executeTest();
    }

    public static boolean nameValidator(Object object) {
        TestExecutor testExecutor = new TestExecutor();
        NameValidator nameValidator = new NameValidator(object);
        testExecutor.addTest(nameValidator);
        return testExecutor.executeTest();
    }

    public static boolean ageValidator(Object object) {
        TestExecutor testExecutor = new TestExecutor();
        AgeValidator ageValidator = new AgeValidator(object);
        testExecutor.addTest(ageValidator);
        return testExecutor.executeTest();
    }
}
