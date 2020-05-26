package com.biotag.datastructor;

import java.util.concurrent.ConcurrentHashMap;

public class Cchmdemo2 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> ccm = new ConcurrentHashMap<>();
        ccm.put("1", "lxh");
        String s = ccm.get("1");
        System.out.println(s);

    }
}
