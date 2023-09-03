package servGPS;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/*
Сервер отправки
исполует Сервиса хранения
содержание объекта выводится

 */

@Component
@Service
public class OtprService {
    String gpsData;
    String data;
    @Autowired
    public HranService hranService;
    private static final Logger log = LoggerFactory.getLogger(OtprService.class);


/*
    // каждые 10 сек
    @Scheduled(fixedDelay = 5_000) //PostConstruct
    private void init(){
        data = hranService.otprInit();
        System.out.println("\nНАКОПЛЕННЫЕ ДАННЫЕ = " +data+ "\n");
    }

 */


    @Scheduled(fixedDelay = 10_000, initialDelay = 10_000)
    @RequestMapping(value = "/gps", method = RequestMethod.POST) //produces={"text/plain; application/json"} charset=UTF-8
    public String postRestT() throws IOException, InterruptedException {
        data = hranService.take(); //

        String resourceUrl = "http://localhost:8080/gps";
        RestTemplate restTemplate = new RestTemplate();

        gpsData = restTemplate.postForObject(resourceUrl, data, String.class);

        log.info("Coordinate:"+gpsData);

        return gpsData;
    }


}
