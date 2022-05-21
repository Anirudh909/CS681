package edu.umb.cs681.hw10;

public class Main implements Runnable {

    public void run() {
        Aircraft aircraft = new Aircraft(new Position(28.12345, 89.78236458971 , 321.126));
        aircraft.setPosition(new Position(29.5082820767, 63.8574379432, 225.331));
        System.out.println(aircraft.getPosition());
    }

    public static void main(String[] args) {
        Main t1 = new Main();
        Main t2 = new Main();
        Main t3 = new Main();
        Main t4 = new Main();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }
}
