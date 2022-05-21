package edu.umb.cs681.hw10;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class Aircraft
{   private ReentrantLock lock = new ReentrantLock();
    private Position position;
    public Aircraft(Position pos) {
        position = pos;
    }
    public void setPosition(Position pos) {
        lock.lock();
        try{
            position = pos;
        }finally {
            lock.unlock();
        }
    }

    public Position getPosition(){
        lock.lock();
        try{
            return position;
        }finally {
            lock.unlock();
        }
    }
}
