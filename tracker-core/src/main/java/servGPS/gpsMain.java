package servGPS;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class gpsMain {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GpsContext.class);
    }

}
