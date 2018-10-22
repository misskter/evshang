package com.evshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;


//@SpringBootApplication
public class UserServiceApplication {




	public static void main(String[] args) {



        Callable<Integer> callable = new Callable<Integer>() {
            private  Integer num = 0;

            @Override
            public Integer call() throws Exception {
                return num++;
            }
        };


        for (int i = 0;i<100;i++) {
            FutureTask futureTask = new FutureTask(callable);
            ExecutorService executorService = Executors.newCachedThreadPool();

            executorService.submit(futureTask);
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }



        }











        //SpringApplication.run(UserServiceApplication.class, args);
	}

}
