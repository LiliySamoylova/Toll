package services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jd.domain.GpsCoor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


@Service
public class HranServiceBoot {
    List dataGps = new ArrayList();
    Queue data = new LinkedList();

    private static final Logger log = LoggerFactory.getLogger(HranServiceBoot.class);
    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;
    @Autowired
    private service_Gps gpsService;

    @Scheduled (cron = "*/1 * * * * *") //PostConstruct
    private void init() {
      dataGps = gpsService.dataGps();
    System.out.println("Получен List = " +dataGps);
    }

    @Scheduled(fixedDelay = 5_000)
    void take() throws InterruptedException {
        log.info("Очередь");
        long current = System.currentTimeMillis();
        log.info((current - previous) + "QueueService" + queue.poll(500, TimeUnit.MILLISECONDS));
        previous = current;
        data = queue;
    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException, JsonProcessingException {
        int i = putCount++;

        GpsCoor gpsJson = new GpsCoor(888.0, 56.0, 1145.0);
        gpsJson.shirota = (double) dataGps.get(0);
        gpsJson.dolgota = (double) dataGps.get(1);
        gpsJson.azimyt = (int) dataGps.get(2);

        ObjectMapper mapper = new ObjectMapper();
        String jsonGps = mapper.writeValueAsString(gpsJson);

        log.info("Queue tick " + i);
        queue.put("Тройка => " + jsonGps);
    }

    public Queue otprInit() {
        return data;
    }

}
