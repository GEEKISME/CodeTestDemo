package com.biatag.anotationreflect;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.sun.org.apache.xpath.internal.objects.XObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflectdemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        person.age = 22;
        test(person);
    }

    public static void test(Object o) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = o.getClass();
        Field ageField= c.getDeclaredField("age");
        System.out.println(ageField.getInt(o));

        Method method = c.getDeclaredMethod("sayHello",String.class);
        method.invoke(o,"lxh");

        Method method1 = c.getDeclaredMethod("sayBye",String.class);
        method1.setAccessible(true);
        method1.invoke(o, "lxh");

    }

}


class Person{

    int age;

    public void sayHello (String name){
        System.out.println("hello"+name);
    }

    private void sayBye(String name){
        System.out.println("byebye"+name);
    }
}
