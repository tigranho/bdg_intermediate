package com.bdg;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionChecker {
    public void showClassName (Object object){
        Class smallclass = object.getClass();
        System.out.println(smallclass.getName());
    }

    public void showClassFields(Object object){
        Class smallclass = object.getClass();
        Field[] fields = smallclass.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
    }
    // method list

    public void showClassMethod(Object object){
        Class smallclass = object.getClass();
        Method[] methods = smallclass.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
    public void showFieldsAnnotations(Object object){
        Class smallclass = object.getClass();
        Field [] fields = smallclass.getDeclaredFields();
        for(Field field : fields){
            Annotation[] annotations = field.getAnnotations();
            for(Annotation annotation : annotations){
                System.out.println(field.getName() + ":" + annotation.toString());
            }
        }
    }
}
