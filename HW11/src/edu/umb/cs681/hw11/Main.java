package edu.umb.cs681.hw11;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Thread>  threads = new ArrayList<>();
        ArrayList<RequestHandler> requestHandlers = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            requestHandlers.add(new RequestHandler(i));
            threads.add(new Thread(requestHandlers.get(i)));
            threads.get(i).start();
        }

        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " " + e);
        }
        for(int i = 0; i < 12; i++) {
            requestHandlers.get(i).setDone();
            threads.get(i).interrupt();
            try {
                threads.get(i).join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
