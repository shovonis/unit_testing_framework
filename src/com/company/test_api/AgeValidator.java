package com.company.test_api;

import com.company.annotation.Range;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class AgeValidator implements Test {
    private Object object;
    private boolean isAgeValid = false;

    public AgeValidator(Object object) {
        this.object = object;
    }

    @Override
    public boolean run() {
        try {
            Class objectClass = object.getClass();
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Annotation annotation = field.getAnnotation(Range.class);
                if (annotation instanceof Range) {
                    Object valueOfTheField = field.get(object);
                    Integer age = (Integer) valueOfTheField;
                    int maxValue = ((Range) annotation).max();
                    int minValue = ((Range) annotation).min();
                    if (age >= minValue && age <= maxValue) {
                        isAgeValid = true;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return isAgeValid;
    }
}
