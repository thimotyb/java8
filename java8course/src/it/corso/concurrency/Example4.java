package it.corso.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Demonstrate using fork/join to perform divide and conquer on a potentially 
 * very time consuming task.
 *  What this example does is sum all the elements of an array, 
 *  using parallelism to potentially process different 5000-element segments in parallel.
 * @author thimoty
 *
 */
public class Example4 {

	public static void main(String[] args) {
		int[] bigArray = new int[Sum.SEQUENTIAL_THRESHOLD*10000];
		Random rnd = new Random();
		for (int i = 0; i < Sum.SEQUENTIAL_THRESHOLD*10000; i++) {
			bigArray[i] = rnd.nextInt(101);
		}
		System.out.println(Sum.sumArray(bigArray));
	}	
}

class Sum extends RecursiveTask<Long> {
    static final int SEQUENTIAL_THRESHOLD = 5000;

    int low;
    int high;
    int[] array;

    Sum(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }

    protected Long compute() {
        if(high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for(int i=low; i < high; ++i) 
                sum += array[i];
            return sum;
         } else {
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(array, low, mid);
            Sum right = new Sum(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
         }
     }

     static long sumArray(int[] array) {
         return ForkJoinPool.commonPool().invoke(new Sum(array,0,array.length));
     }
}