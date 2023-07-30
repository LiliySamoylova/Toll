package servGPS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

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
    Queue data = new LinkedList();
    @Autowired
    private HranService hranService;

    // каждые 10 сек
    @Scheduled(fixedDelay = 5_000) //PostConstruct
    private void init(){
        data = hranService.otprInit();
        System.out.println("\nНАКОПЛЕННЫЕ ДАННЫЕ = " +data+ "\n");
    }


}
