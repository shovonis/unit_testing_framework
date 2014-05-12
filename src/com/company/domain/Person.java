package com.company.domain;

import com.company.annotation.Email;
import com.company.annotation.Name;
import com.company.annotation.NotNull;
import com.company.annotation.Range;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */


public class Person {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Name
    private String name;


    @Range(min = 20, max = 100)
    private int age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
