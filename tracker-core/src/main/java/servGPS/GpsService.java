package servGPS;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Сервер GPS
первоначальные данные взял из файла app.properties (широты, долготы, азимута)
передает данные каждую секунду серверу хранения (в очередь)
 */
@Service
public class GpsService{
    private int count;

    @Value("${double1.prop}")
    Double double1Prop;
    @Value("${double2.prop}")
    Double double2Prop;
    @Value("${int.prop}")
    Double intProp;

    public GpsService() {

    }

    public GpsService(double shirota, double dolgota, double azimyt) {
        this.double1Prop = shirota;
        this.double2Prop = dolgota;
        this.intProp = azimyt;

    }

    /*

        @PostConstruct
        public void init1() {
            System.out.println("double1Prop = " + double1Prop);
            System.out.println("double2Prop = " + double2Prop);
            System.out.println("intProp = " + intProp);
        }
     */
    @Scheduled(cron = "${cron.prop}")
    private void tick() {
        //System.out.println("tick " + count++);
        //init1();
        double1Prop = double1Prop + 0.007;
        double2Prop = double2Prop + 0.005;
        intProp++;
    }

    public List<Double> callFromInit() {
        List<Double> dataGps = new ArrayList<Double>();
        dataGps.add(double1Prop);
        dataGps.add(double2Prop);
        dataGps.add(intProp);
       // System.out.println("Данные записались в лист и передаются в сервер хранения");
     //  System.out.println("List = " +dataGps);
        return dataGps;
    }

}
