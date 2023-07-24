package jdev.services;

import org.springframework.stereotype.Service;

@Service
public class DataSendService {
    public void callFromInit() {
        System.out.println("DataSendService.callFromInit");
    }
}
