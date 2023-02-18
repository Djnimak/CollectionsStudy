package main.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadStudy
{
   public static void main(String[] args)
   {
      long startTime = System.currentTimeMillis();
      Runnable everySecond = () -> System.out.println((System.currentTimeMillis() - startTime) / 1000);
      Runnable everyFive = () -> System.out.println("Минуло 5 секунд");

      ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
      executorService.scheduleAtFixedRate(everySecond, 1, 1, TimeUnit.SECONDS);
      executorService.scheduleAtFixedRate(everyFive, 5, 5, TimeUnit.SECONDS);
   }
}
