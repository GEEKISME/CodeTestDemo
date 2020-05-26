package com.biatag.anotationreflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Student student = new Student();
        student.setAge(18);
        student.setAddress("luoxiulu");
        test(student);
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

        boolean b = c.isAnnotationPresent(MyAnno.class);
        System.out.println("有myanno注解吗："+b);

        MyAnno myAnno = ageField.getDeclaredAnnotation(MyAnno.class);
        System.out.println("age 上的myanno 的name 是： "+myAnno.name());
    }
}
