package edu.umb.cs681.hw11;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    HashMap<java.nio.file.Path, Integer> hashMap = new HashMap<java.nio.file.Path, Integer>();
    private ReentrantLock nonStaticLock = new ReentrantLock();
    private static ReentrantLock staticLock = new ReentrantLock();
    private static AccessCounter instance = null;

    private AccessCounter(){}


    public static AccessCounter getInstance()
    {
        staticLock.lock();
        try {
            if(instance==null)
            {
                instance = new AccessCounter();
            }
        } finally {
            staticLock.unlock();
        }
        return instance;
    }

    public void increment(java.nio.file.Path path)
    {
        nonStaticLock.lock();
        try {
            if(hashMap.containsKey(path)) {
                System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + hashMap.get(path));
                hashMap.put(path, hashMap.get(path)+1);
            } else {
                System.out.println(Thread.currentThread().getName() + " set " + path + " to 0");
                hashMap.put(path, 1);
            }
        }finally {
            nonStaticLock.unlock();
        }
    }

    public int getCount(java.nio.file.Path path)
    {
        int count = 0;
        nonStaticLock.lock();
        try {
            if(hashMap.containsKey(path)) {
                count = hashMap.get(path);
                System.out.println(Thread.currentThread().getName() + " get " + path + " count " + count);
            } else {
                System.out.println(Thread.currentThread().getName() + " get " + path + " count " + 0);
            }
        } finally {
            nonStaticLock.unlock();
        }
        return count;
    }

}
