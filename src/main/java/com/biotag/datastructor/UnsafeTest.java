package com.biotag.datastructor;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    private int count = 0;
    private String[] arr = {"1","2","3","4","5","6"};
    private static Unsafe UNSAFE = null;
    private static long COUNT_OFFSET;
    static {
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            COUNT_OFFSET = UNSAFE.objectFieldOffset(UnsafeTest.class.getDeclaredField("count"));

        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        final UnsafeTest unsafeTest = new UnsafeTest();
        //数组中存储的对象的对象头的大小
        int ns = UNSAFE.arrayIndexScale(String[].class);
        //数组中第一个元素的起始位置
        int base = UNSAFE.arrayBaseOffset(String[].class);
        Object object = UNSAFE.getObject(unsafeTest.arr, base + 5 * ns);
        System.out.println(object);
    }
}
