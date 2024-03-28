package it.corso.concurrency.blockingqueue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable{
 
private BlockingQueue<Message> queue;
private CountDownLatch latch;

     
    public Consumer(BlockingQueue<Message> q, CountDownLatch latch){
        this.queue=q;
        this.latch=latch;
    }
 
    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
	            Thread.sleep(100);
	            System.out.println(Thread.currentThread().getName()+"-"+new Date().getTime()+"-Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Counting down latch");
            latch.countDown();
        }
    }
    
    public void shutdown() throws InterruptedException {
        throw new InterruptedException("Interrupted by User With Ctl C");
    }
}
