package edu.umb.cs681.hw11;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

    AtomicBoolean done = new AtomicBoolean(false);
    private int id;

    public RequestHandler(int id) {
        this.id = id;
    }

    public void setDone()
    {
        done.set(true);
    }


    @Override
    public void run() {
        Random random = new Random();
        int randomHtml = random.nextInt(3);
        while(true) {
            if(done.get()) {
                System.out.println(Thread.currentThread().getName() + " done");
                break;
            }
            java.nio.file.Path path = null;
            switch(randomHtml){
                case 0:
                    path = java.nio.file.Paths.get("fileOne.html");
                    break;
                case 1:
                    path = java.nio.file.Paths.get("fileTwo.html");
                    break;
                case 2:
                    path = java.nio.file.Paths.get("fileThree.html");
                    break;
                default:
            }

            AccessCounter.getInstance().increment(path);
            AccessCounter.getInstance().getCount(path);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " " + e);
                continue;
            }
        }

    }
}