package com.biotag.jvmclass;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        S.SCount = 1000;
        String property = System.getProperty("java.ext.dirs");
        String propertys = System.getProperty("java.class.path");
        System.out.println(property);
        System.out.println("============================");
        String[] strings = propertys.split(";");
        for (String s:
             strings) {
            System.out.println(s);
        }
    }
}
