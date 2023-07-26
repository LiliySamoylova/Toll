package servGPS;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class gpsMain {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GpsContext.class);
    }
}
