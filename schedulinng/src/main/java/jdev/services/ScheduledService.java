package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    private int count;

    //@Scheduled (fixedDelay = 3000, initialDelay = 5000) // 5 сек сначало, далее 3
    @Scheduled (cron = "*/4 * * * * *") // с мин ч дни недели месяц
    private void tick() {
        System.out.println("ScheduledService.tick"+ count++);
    }
}
