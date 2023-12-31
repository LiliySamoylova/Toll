package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class FirstController {
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @RequestMapping(value = "/gps", produces = {"text/plain;charset=UTF-8"})
    public String gpsController(@RequestBody String gpsCoord) throws IOException {

        log.info("\n Controller \n"+gpsCoord);
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(gpsCoord);
        writer.close();

        return gpsCoord;
    }


}
