package com.biotag.datastructor;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Hashtable;

public class CurrenthashMapDemo {
    private int i = 0;
    private static Unsafe UNSAFE = null;
    private static long I_OFFSET ;

    static {
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            I_OFFSET = UNSAFE.objectFieldOffset(CurrenthashMapDemo.class.getDeclaredField("i"));

        }catch (Exception e){

        }
    }



    public static void main(String[] args) {
//        Hashtable<String , String > ht = new Hashtable<>();
//        ht.put("1", "lxh");
//        ht.put("2", "fcj");
//        String s = ht.get("1");
//        System.out.println(s);

        final CurrenthashMapDemo c = new CurrenthashMapDemo();
        new Thread(()->{
            while (true){
//                c.i++;
                boolean b = UNSAFE.compareAndSwapInt(c, I_OFFSET, c.i, c.i + 1);


                if(b){
                    int i = UNSAFE.getIntVolatile(c, I_OFFSET);

                    System.out.println("线程1修改后为："+c.i);
                }else {
                    System.out.println("线程1没有修改");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(()->{
            while (true){
                boolean b = UNSAFE.compareAndSwapInt(c, I_OFFSET, c.i, c.i + 1);

                if(b){
                    int i = UNSAFE.getIntVolatile(c, I_OFFSET);
                    System.out.println("线程2修改后为："+c.i);
                }else {
                    System.out.println("线程2没有修改");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
