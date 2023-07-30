package servGPS;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/*
Сервер хранения
получил данные из Сервер GPS
записал в очередь
отправил серверу отправки
 */

@Service
public class HranService {
    List dataGps = new ArrayList();
    Queue data = new LinkedList();

    private static final Logger log = LoggerFactory.getLogger(HranService.class);
    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;
    @Autowired
    private GpsService gpsService;

    @Scheduled (cron = "*/1 * * * * *") //PostConstruct
    private void init() {
      dataGps = gpsService.callFromInit();
   // System.out.println("Получен List = " +dataGps);
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

        GpsJson gpsJson = new GpsJson();
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
