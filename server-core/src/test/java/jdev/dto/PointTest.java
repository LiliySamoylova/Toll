package jdev.dto;


//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


public class PointTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1489900897458}";
    private String autoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        Point point = new Point();
        point.setLat(56, false);
        point.setLon(74, true);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

}

