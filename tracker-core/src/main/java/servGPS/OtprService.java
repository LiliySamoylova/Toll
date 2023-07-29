package servGPS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/*
Сервер отправки
исполует Сервиса хранения
содержание объекта выводится

по данным:
значения широты, долготы, азимута записываются в лист. лист не накапливается.
а каждый раз в очереди выводит тройку
 */

public class OtprService {

    List list = new ArrayList();
    @Autowired
    private HranService hranService;

    // каждые 10 сек
    @Scheduled(cron = "*/10 * * * * *") //PostConstruct
    private void init() throws InterruptedException {
        hranService.take();
    }


}
