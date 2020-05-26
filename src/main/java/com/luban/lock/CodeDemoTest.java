package com.luban.lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

public class CodeDemoTest {

    static  L l = new L(1,true);

    public static void main(String[] args) {
        System.out.println("开始了:");
        System.out.println(Integer.toHexString(l.hashCode()));
        System.out.println(ClassLayout.parseInstance(l).toPrintable());

    }


    /**
     * java 当中有哪些锁：公平锁
     */
    public static  void lockTest(){
        System.out.println("xxxxx");
    }
}
