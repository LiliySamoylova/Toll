package jdev;

import jdev.services.DataPeekService;
import jdev.services.DataSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectionContext {
    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }
}
