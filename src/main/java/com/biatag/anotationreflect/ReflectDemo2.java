package com.biatag.anotationreflect;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("E:\\idea_workspace\\CodeTestDemo\\src\\main\\java\\com\\biatag\\anotationreflect\\aa.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        System.out.println(line);

        Class<?> clazz = Class.forName(line);
//        System.out.println(clazz.toString());
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(constructors.length);
        System.out.println(constructors[0]);
        System.out.println(constructors[1]);
        Constructor<?> c = constructors[0];
        Object obj = c.newInstance();
        Student s = (Student)obj;
        s.sayHello("lxh");

    }
}
