package servGPS;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/*
Сервер GPS
первоначальные данные взял из файла app.properties (широты, долготы, азимута)
передает данные каждую секунду серверу хранения (в очередь)
 */

@Service
public class GpsService {
    private int count;

    @Value("${double1.prop}")
    Double double1Prop;
    @Value("${double2.prop}")
    Double double2Prop;
    @Value("${int.prop}")
    Integer intProp;

    @PostConstruct
    public void init() {
        System.out.println("double1Prop = " + double1Prop);
        System.out.println("double2Prop = " + double2Prop);
        System.out.println("intProp = " + intProp);
    }

    @Scheduled(cron = "${cron.prop}")
    private void tick() {
        System.out.println("InjectedService.tick " + count++);
       // init();
        double1Prop = double1Prop + 0.007;
        double2Prop = double2Prop + 0.005;
        intProp++;
    }

}
