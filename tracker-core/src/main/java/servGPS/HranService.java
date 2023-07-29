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
записал в очередь
 */

@Service
public class HranService {
  List dataGps = new ArrayList();
  @Autowired
  private GpsService gpsService;

  @Scheduled (cron = "*/1 * * * * *") //PostConstruct
  private void init() {
    dataGps = gpsService.callFromInit();
   // System.out.println("Получен List = " +dataGps);
  }

    private static final Logger log = LoggerFactory.getLogger(HranService.class);

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled(fixedDelay = 3_000)
    void take() throws InterruptedException {
        log.info("\nОчередь\n");
        long current = System.currentTimeMillis();
        log.info((current - previous) + "QueueService" + queue.poll(500, TimeUnit.MILLISECONDS));
//        System.out.println((current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;
    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("ScheduledQueueService.put " + i);
        queue.put("new string => " + dataGps);

    }




}
