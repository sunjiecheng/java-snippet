package com.sjc.java.thread.basic;

import java.util.concurrent.*;

/**
 * @author jiecheng
 * @create 2020-11-29 下午9:19
 */
public class CallableDemo implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.create service
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 2.submit executor
        Future<Boolean> submit1 = service.submit(new CallableDemo());
        Future<Boolean> submit2 = service.submit(new CallableDemo());
        Future<Boolean> submit3 = service.submit(new CallableDemo());
        // 3.get result
        Boolean b1 = submit1.get();
        Boolean b2 = submit2.get();
        Boolean b3 = submit3.get();
        // 4.service shutdown
        service.shutdown();
    }
}
