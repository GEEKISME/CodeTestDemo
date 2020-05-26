package com.biotag.threadssynchronized;

import com.luban.lock.L;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

public class SynchDemo implements Runnable {

    /**
     * syn 改变的是对象的什么呢
     */
    int count = 0;
    static LubanLock lubanLock = new LubanLock();

    ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        //synch 锁住的是对象不是代码块，syn可以所对象，也能所整个类也就是class
        synchronized (lubanLock){
            count++;
            reentrantLock.lock();
        }
    }

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(lubanLock).toPrintable());

    }
}
