package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDateTime localTime = LocalDateTime.now();
        Directory root = new Directory(null, "root", 0, localTime);
        Directory applications = new Directory(root, "applications", 0, localTime);
        Directory home = new Directory(root, "home", 0, localTime);
        Directory code = new Directory(home, "code", 0, localTime);
        File a = new File(applications, "a", 6, localTime);
        File b = new File(home, "b", 30, localTime);
        File c = new File(code, "c", 40, localTime);
        File d = new File(code, "d", 50, localTime);

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {

                System.out.println(root.getName());
                System.out.println(applications.getName());
                System.out.println(home.getName());
                System.out.println(code.getName());

                System.out.println(a.getName());
                System.out.println(b.getName());
                System.out.println(c.getName());
                System.out.println(d.getName());

                System.out.println(root.getSize());
                System.out.println(applications.getSize());
                System.out.println(home.getSize());
                System.out.println(code.getSize());

                System.out.println(a.getParent().getParent().countChildren());
                System.out.println(b.getParent().getParent().countChildren());
                System.out.println(c.getParent().getParent().countChildren());
                System.out.println(d.getParent().getParent().countChildren());

                System.out.println(home.getParent().countChildren());
            }));
        }

        for (Thread t : threads) {
            try {
                t.start();
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}