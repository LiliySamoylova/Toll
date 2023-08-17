package controllers;

import jd.domain.GpsCoor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class firstController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Coordinati, %s!";

    private static final Logger log = LoggerFactory.getLogger(firstController.class);

    @RequestMapping("/gess")
    public GpsCoor greeting(String name) {
        return new GpsCoor(counter.incrementAndGet(), String.format(template, name));
    }


    @RequestMapping(value = "/gps", produces = {"text/plain;charset=UTF-8"})
    public String gpsController(@RequestBody String gpsCoord) throws IOException {

        log.info("\n Controller \n"+gpsCoord);
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(gpsCoord);
        writer.close();

        return gpsCoord;
    }


}
