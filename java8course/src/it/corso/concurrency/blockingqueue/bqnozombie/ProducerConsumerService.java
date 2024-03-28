package it.corso.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
 
 
public class ProducerConsumerService {
 
    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        
        // Create a Latch
        CountDownLatch latch = new CountDownLatch(5); // Latching only the consumers
        
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue, latch);
        Consumer consumer2 = new Consumer(queue, latch);
        Consumer consumer3 = new Consumer(queue, latch);
        Consumer consumer4 = new Consumer(queue, latch);
        Consumer consumer5 = new Consumer(queue, latch);
        //starting producer to produce messages in queue
        new Thread(producer, "prod1").start();
        //starting consumer to consume messages from queue
        new Thread(consumer, "cons1").start();
        new Thread(consumer2, "cons2").start();
        new Thread(consumer3, "cons3").start();
        new Thread(consumer4, "cons4").start();
        new Thread(consumer5, "cons5").start();
        System.out.println("Producer and Consumer has been started");
        
     // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Caught shutdown hook");
            try {
            	consumer.shutdown();
            	consumer2.shutdown();
            	consumer3.shutdown();
            	consumer4.shutdown();
            	consumer5.shutdown();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Application has exited");
        }

        ));

        
        try {
        	System.out.println("Waiting on latch...");
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Application got interrupted: "+e);
        } finally {
            System.out.println("Application is closing.");
        }
    }
 
}
