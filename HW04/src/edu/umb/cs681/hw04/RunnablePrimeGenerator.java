package edu.umb.cs681.hw04;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }
    public static void main(String[] args) {
        System.out.println("\n Using Single thread and a main thread \n");
        RunnablePrimeGenerator gen = new RunnablePrimeGenerator(1L, 2_000_000L);
        Thread thread = new Thread(gen);
        long start = System.currentTimeMillis();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {}
        long end = System.currentTimeMillis();
        float time1 = (end - start) / 1000F;

        long primeNum = gen.getPrimes().size() ;
        System.out.println("\n" + primeNum + " totol number of prime numbers are found.");
        System.out.println("Time taken with 1 thread: " + time1 + " seconds");
        System.out.println("\n-------------------------------------------------\n");

        System.out.println("\n Using Two threads and a main thread \n");
        RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1L, 1_000_000L);
        RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(1_000_000L, 2_000_000L);
        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        end = System.currentTimeMillis();
        float time2 = (end - start) / 1000F;


        primeNum = gen1.getPrimes().size() + gen2.getPrimes().size() ;
        System.out.println("\n" + primeNum + " total numbers of prime number are found.");
        System.out.println("Time taken with 2 thread: " + time2 + " seconds");
        System.out.println("\n-------------------------------------------------\n");


        System.out.println("\n Using four threads and a main thread \n");
        RunnablePrimeGenerator gen3 = new RunnablePrimeGenerator(1L, 5_00_000L);
        RunnablePrimeGenerator gen4 = new RunnablePrimeGenerator(5_00_000L, 1_000_000L);
        RunnablePrimeGenerator gen5 = new RunnablePrimeGenerator(1_000_000L, 1_500_000L);
        RunnablePrimeGenerator gen6 = new RunnablePrimeGenerator(1_500_000L, 2_000_000L);
        Thread t3 = new Thread(gen3);
        Thread t4 = new Thread(gen4);
        Thread t5 = new Thread(gen5);
        Thread t6 = new Thread(gen6);

        start = System.currentTimeMillis();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {}
        end = System.currentTimeMillis();
        float time3 = (end - start) / 1000F;


        primeNum = gen3.getPrimes().size() + gen4.getPrimes().size()+gen5.getPrimes().size() + gen6.getPrimes().size()  ;
        System.out.println("\n" + primeNum + " total number of prime numbers found.");
        System.out.println("Time taken with 4 thread: " + time3 + " seconds");
        System.out.println("\n-------------------------------------------------\n");

        System.out.println("\n Using Eight threads and a main thread \n");
        RunnablePrimeGenerator gen7 = new RunnablePrimeGenerator(1L, 250000L);
        RunnablePrimeGenerator gen8 = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator gen9 = new RunnablePrimeGenerator(500000L, 750000L);
        RunnablePrimeGenerator gen10 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator gen11 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator gen12 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator gen13 = new RunnablePrimeGenerator(1500000L, 1750000L);
        RunnablePrimeGenerator gen14 = new RunnablePrimeGenerator(1750000L, 2000000L);

        Thread t7 = new Thread(gen7);
        Thread t8 = new Thread(gen8);
        Thread t9 = new Thread(gen9);
        Thread t10 = new Thread(gen10);
        Thread t11 = new Thread(gen11);
        Thread t12 = new Thread(gen12);
        Thread t13 = new Thread(gen13);
        Thread t14 = new Thread(gen14);

        start = System.currentTimeMillis();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        try {
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
        } catch (InterruptedException e) {
        }

        end = System.currentTimeMillis();
        float time4 = (end - start) / 1000F;

        primeNum = gen7.getPrimes().size() + gen8.getPrimes().size() + gen9.getPrimes().size() + gen10.getPrimes().size()
                + gen11.getPrimes().size() + gen12.getPrimes().size() + gen13.getPrimes().size() + gen14.getPrimes().size();
        System.out.println("\n" + primeNum + " total number of prime numbers found.");
        System.out.println("Time taken with 8 threads: " + time4 + " seconds");
        System.out.println("\n--------------------------------------------------\n");

        System.out.println("\n Using Sixteen threads and a main thread \n");

        RunnablePrimeGenerator gen15 = new RunnablePrimeGenerator(1L, 125000L);
        RunnablePrimeGenerator gen16 = new RunnablePrimeGenerator(125000L, 250000L);
        RunnablePrimeGenerator gen17 = new RunnablePrimeGenerator(250000L, 375000L);
        RunnablePrimeGenerator gen18 = new RunnablePrimeGenerator(375000L, 500000L);
        RunnablePrimeGenerator gen19 = new RunnablePrimeGenerator(500000L, 625000L);
        RunnablePrimeGenerator gen20 = new RunnablePrimeGenerator(625000L, 750000L);
        RunnablePrimeGenerator gen21 = new RunnablePrimeGenerator(750000L, 875000L);
        RunnablePrimeGenerator gen22 = new RunnablePrimeGenerator(875000L, 1000000L);
        RunnablePrimeGenerator gen23 = new RunnablePrimeGenerator(1000000L, 1125000L);
        RunnablePrimeGenerator gen24 = new RunnablePrimeGenerator(1125000L, 1250000L);
        RunnablePrimeGenerator gen25 = new RunnablePrimeGenerator(1250000L, 1375000L);
        RunnablePrimeGenerator gen26 = new RunnablePrimeGenerator(1375000L, 1500000L);
        RunnablePrimeGenerator gen27 = new RunnablePrimeGenerator(1500000L, 1625000L);
        RunnablePrimeGenerator gen28 = new RunnablePrimeGenerator(1625000L, 1750000L);
        RunnablePrimeGenerator gen29 = new RunnablePrimeGenerator(1750000L, 1875000L);
        RunnablePrimeGenerator gen30 = new RunnablePrimeGenerator(1875000L, 2000000L);

        Thread t15 = new Thread(gen15);
        Thread t16 = new Thread(gen16);
        Thread t17 = new Thread(gen17);
        Thread t18 = new Thread(gen18);
        Thread t19 = new Thread(gen19);
        Thread t20 = new Thread(gen20);
        Thread t21 = new Thread(gen21);
        Thread t22 = new Thread(gen22);
        Thread t23 = new Thread(gen23);
        Thread t24 = new Thread(gen24);
        Thread t25 = new Thread(gen25);
        Thread t26 = new Thread(gen26);
        Thread t27 = new Thread(gen27);
        Thread t28 = new Thread(gen28);
        Thread t29 = new Thread(gen29);
        Thread t30 = new Thread(gen30);

        start = System.currentTimeMillis();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t20.start();
        t21.start();
        t22.start();
        t23.start();
        t24.start();
        t25.start();
        t26.start();
        t27.start();
        t28.start();
        t29.start();
        t30.start();
        try {
            t15.join();
            t16.join();
            t27.join();
            t18.join();
            t19.join();
            t20.join();
            t21.join();
            t22.join();
            t23.join();
            t24.join();
            t25.join();
            t26.join();
            t27.join();
            t28.join();
            t29.join();
            t30.join();
        } catch (InterruptedException e) {
        }

        end = System.currentTimeMillis();
        float time5 = (end - start) / 1000F;

        primeNum = gen15.getPrimes().size() + gen16.getPrimes().size() + gen17.getPrimes().size()
                + gen18.getPrimes().size() + gen19.getPrimes().size() + gen20.getPrimes().size() + gen21.getPrimes().size()
                + gen22.getPrimes().size() + gen23.getPrimes().size() + gen24.getPrimes().size() + gen25.getPrimes().size()
                + gen26.getPrimes().size() + gen27.getPrimes().size() + gen28.getPrimes().size() + gen29.getPrimes().size()
                + gen30.getPrimes().size();
        System.out.println("\n" + primeNum + " total no of prime numbers found.");
        System.out.println("Time taken with 16 threads: " + time5 + " seconds");
        System.out.println("--------------------------------------------------");

    }

}

