package services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class service_Gps {

    private int count;

    @Value("${double11.proper}")
    private Double shirota;
    @Value("${double21.proper}")
    private Double dolgota;
    @Value("${int1.proper}")
    private Double azimyt;
/*
    @Scheduled(cron = "${cron.proper}")
    private void tick() {
        System.out.println("tick " + count++);
        //init1();
        shirota = shirota + 0.007;
        dolgota = dolgota + 0.005;
        azimyt++;
    }

 */

    public List dataGps() {
        List<Double> dataGps = new ArrayList<Double>();
        dataGps.add(shirota);
        dataGps.add(dolgota);
        dataGps.add( azimyt);
        // System.out.println("Данные записались в лист и передаются в сервер хранения");
        System.out.println("List = " +dataGps);
        shirota = shirota + 0.07;
        dolgota = dolgota + 0.05;
        azimyt++;
        return dataGps;
    }
}
