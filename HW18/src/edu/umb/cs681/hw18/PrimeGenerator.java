package edu.umb.cs681.hw18;


import java.util.LinkedList;


public class PrimeGenerator {
    protected long from, to;
    protected LinkedList<Long> primes = new LinkedList<Long>();

    public PrimeGenerator(long from, long to){
        if(from >= 1 && to > from){
            this.from = from;
            this.to = to;
        }else{
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public LinkedList<Long> getPrimes(){ return primes; };

    protected boolean isEven(long n){
        if(n%2 == 0){ return true; }
        else{ return false; }
    }

    protected boolean isPrime(long n){
        
        if(n <= 1){ return false; }
        
        if( n > 2 && isEven(n) ){ return false; }
        long i;

        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
     
        if (i == 1){ return true; }
        else{ return false; }
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            if( isPrime(n) ){ primes.add(n); }
        }
    }

}

