package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class ScheduledQueueService {


    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled (fixedDelay = 2000)
     void take() throws InterruptedException {
        System.out.println("take trying!!!");
        long current = System.currentTimeMillis();
        System.out.println((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
//        System.out.println((current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;

    }

    @Scheduled (fixedDelay = 1_000)
     void put() throws InterruptedException {
        int i = putCount++;
        System.out.println("ScheduledQueueService.put " + i);
        queue.put("new string => " + i);

    }
}
