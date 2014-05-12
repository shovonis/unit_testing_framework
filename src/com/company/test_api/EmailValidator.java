package com.company.test_api;

import com.company.annotation.Email;
import com.company.annotation.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/13/14
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailValidator implements Test {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern;
    Matcher matcher;
    private Object object;

    public EmailValidator(Object object) {
        this.object = object;
    }

    @Override
    public boolean run() {
        pattern = Pattern.compile(EMAIL_PATTERN);
        try {
            Class objectClass = object.getClass();
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Annotation[] annotations = field.getDeclaredAnnotations();
                Object valueOfTheField = field.get(object);
                String emailFromObject = null;
                if (valueOfTheField instanceof String)
                    emailFromObject = (String) valueOfTheField;
                for (Annotation ann : annotations) {

                    if (ann instanceof NotNull) {
                        if (emailFromObject == null)
                            return false;
                    } else if (ann instanceof Email) {
                        matcher = pattern.matcher(emailFromObject);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return matcher.matches();

    }
}
