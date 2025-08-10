package ThreadPoolDemo;

import java.util.concurrent.*;


public class ThreadpoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for(int i=0;i<5;i++){
            int taskId=i;
            pool.submit(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " started on " + threadName);
               try{
                   Thread.sleep(10_000);
               }catch (InterruptedException ignored){}
                System.out.println("Task " + taskId + " finished on " + threadName);
            });
        }
        pool.shutdown();
        pool.awaitTermination(1,TimeUnit.MINUTES);
        System.out.println("All tasks completed");
    }
}
