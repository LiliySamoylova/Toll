package jdev;

import jdev.services.InjectedService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class PropContext {

    @Bean
    public InjectedService injectedService() {
        return new InjectedService();
    }
}
