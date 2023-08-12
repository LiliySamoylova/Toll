package servGPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import jd.domain.GpsCoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Сервер отправки
исполует Сервиса хранения
содержание объекта выводится

 */

public class OtprService {
    //Queue data = new LinkedList();
    String data;
    @Autowired
    private HranService hranService;
/*
    // каждые 10 сек
    @Scheduled(fixedDelay = 5_000) //PostConstruct
    private void init(){
        data = hranService.otprInit();
        System.out.println("\nНАКОПЛЕННЫЕ ДАННЫЕ = " +data+ "\n");
    }

 */


    @Scheduled(fixedDelay = 5_000)
    @RequestMapping(value = "/gps", method = RequestMethod.POST, produces={"application/json;; charset=UTF-8"}) //text/plain  application/json;
    public String postRestT(){
        RestTemplate restTemplate = new RestTemplate();
        data = hranService.otprInit();

        String resourceUrl = "http://localhost:8080/gps";
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

        String gpsData = restTemplate.postForObject(resourceUrl, data, String.class);

        System.out.println("\n");
        System.out.println(gpsData);
        System.out.println("\n");

        return gpsData;
    }


}
