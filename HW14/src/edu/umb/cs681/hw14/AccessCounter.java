package edu.umb.cs681.hw14;


import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    public ConcurrentHashMap<java.nio.file.Path, AtomicInteger> concurrentHashMapHashMap = new ConcurrentHashMap<>();
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
       concurrentHashMapHashMap.compute(path, (k, v) -> {
           if(v == null){
               System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + concurrentHashMapHashMap.get(path));
               return new AtomicInteger(1);
           }else{
               System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + concurrentHashMapHashMap.get(path));
               return new AtomicInteger(v.incrementAndGet());
           }
       });
    }

    public AtomicInteger getCount(Path path)
    {
        return concurrentHashMapHashMap.compute(path, (k, v) -> {
            if(v == null){
                System.out.println(Thread.currentThread().getName() + " get count " + path + " count " + concurrentHashMapHashMap.get(path));
                return new AtomicInteger(0);
            }else{
                System.out.println(Thread.currentThread().getName() + " get count " + path + " count " + concurrentHashMapHashMap.get(path));
                return new AtomicInteger(v.get());
            }
        });

    }

}
