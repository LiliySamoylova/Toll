package servGPS;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/*
Сервер хранения
получил данные из Сервер GPS
 */

@Service
public class HranService {
  List dataGps = new ArrayList();
  /*
    private static final Logger log = LoggerFactory.getLogger(HranService.class);

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled(fixedDelay = 2000)
    void take() throws InterruptedException {
        log.info("take trying!!!");
        long current = System.currentTimeMillis();
        log.info((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
//        System.out.println((current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;

    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("ScheduledQueueService.put " + i);
        queue.put("new string => " + i);

    }
*/
    @Autowired
    private GpsService gpsService;

    @PostConstruct
    private void init() {
      dataGps = gpsService.callFromInit();
      System.out.println("List = " +dataGps);
    }


}
