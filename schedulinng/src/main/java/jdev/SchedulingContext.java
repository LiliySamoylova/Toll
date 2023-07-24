package jdev;

import jdev.services.ScheduledService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulingContext {

    @Bean
    public ScheduledService sendService() {
        return new ScheduledService();
    }
}
