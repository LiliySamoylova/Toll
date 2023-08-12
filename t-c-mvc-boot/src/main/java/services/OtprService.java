package services;

import jd.domain.GpsCoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.Queue;

/*
Сервер отправки
исполует Сервиса хранения
содержание объекта выводится

 */

public class OtprService {
    Queue data = new LinkedList();
    @Autowired
    private HranServiceBoot hranService;
  /*
    // каждые 10 сек
    @Scheduled(fixedDelay = 5_000) //PostConstruct
    private void init(){
        data = hranService.otprInit();
        System.out.println("\nНАКОПЛЕННЫЕ ДАННЫЕ = " +data+ "\n");
    }


    public void createProduct() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = "http://localhost:8080/gps";

        //HttpEntity<GpsCoor> request = new HttpEntity<GpsCoor>(new GpsCoor(888.0, 56.0,1145.0));

        HttpEntity<GpsCoor> request = (HttpEntity<GpsCoor>) data;

        String gpsData = restTemplate.postForObject(resourceUrl, request, String.class);

        System.out.println(gpsData);
    }

     */

    @RequestMapping(value = "/gps")
    public String relay(){
        RestTemplate restTemplate = new RestTemplate();
        data = hranService.otprInit();
        String resourceUrl = "http://localhost:8080/gps";

        //HttpEntity<GpsCoor> request = new HttpEntity<GpsCoor>(new GpsCoor(888.0, 56.0,1145.0));

        HttpEntity<GpsCoor> request = (HttpEntity<GpsCoor>) data;

        String gpsData = restTemplate.postForObject(resourceUrl, request, String.class);

        System.out.println(gpsData);

        return gpsData;
    }

}
