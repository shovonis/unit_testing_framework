package com.company.test_api;

import com.company.annotation.Name;
import com.company.annotation.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */

public class NameValidator implements Test {

    private static final String NAME_PATTERN = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
    Pattern pattern;
    Matcher matcher;
    private Object object;

    public NameValidator(Object object) {
        this.object = object;
    }

    @Override
    public boolean run() {
        pattern = Pattern.compile(NAME_PATTERN);
        try {
            Class objectClass = object.getClass();
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Annotation[] annotations = field.getDeclaredAnnotations();
                Object valueOfTheField = field.get(object);
                String name = null;
                if (valueOfTheField instanceof String)
                    name = (String) valueOfTheField;

                for (Annotation ann : annotations) {
                    if (ann instanceof Name){
                        if (ann instanceof NotNull) {
                            if (name == null)
                                return false;
                        } else {
                            matcher = pattern.matcher(name);
                        }
                    }

                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return matcher.matches();

    }
}
