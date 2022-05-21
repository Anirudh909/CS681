package edu.umb.cs681.hw18;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void setDone(){
		lock.lock();
		try{
			done = true;
		}
		finally {
			lock.unlock();
		}
	}

	public void generatePrimes(){
		for (long n = from; n <= to; n++) {
			
			lock.lock();
			try{
				if(done){
					System.out.println("Stopped generating prime numbers.");
					this.primes.clear();
					break;
				}
				if( isPrime(n) ){ this.primes.add(n); }
			}
			finally {
				lock.unlock();
			}

		}
		 
	}
	public static void main(String[] args) {
        RunnableCancellablePrimeGenerator gen1 = new RunnableCancellablePrimeGenerator(1,100);
		RunnableCancellablePrimeGenerator gen2 = new RunnableCancellablePrimeGenerator(100,200);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(gen1);
		executorService.execute(gen2);
		executorService.shutdown();
        try {
			executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen1.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
		gen2.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );

        System.out.println("\n" + gen1.getPrimes().size() + " number of prime numbers found.");
		System.out.println("\n" + gen2.getPrimes().size() + " number of prime numbers found.");

    }
}
