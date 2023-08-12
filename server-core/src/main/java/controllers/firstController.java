package controllers;

import jd.domain.GpsCoor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class firstController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Coordinati, %s!";

    @RequestMapping("/gess")
    public GpsCoor greeting(String name) {
        return new GpsCoor(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/gps")
    public String gpsController(String name) throws IOException {
        System.out.println("\n Controller \n"+name);

        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(name);
        writer.close();

        //return new GpsCoor(counter.incrementAndGet(), String.format(template, name));
        return name;

    }


}
