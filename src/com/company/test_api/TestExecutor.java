package com.company.test_api;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestExecutor {
    private Test test;

    public void addTest(Test test) {
        this.test = test;

    }

    public boolean executeTest() {
        return test.run();
    }
}
