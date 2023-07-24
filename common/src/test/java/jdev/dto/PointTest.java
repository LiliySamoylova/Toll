package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PointTest {

    private String json = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1489900897458}";
    private String autoId = "o567gfd";

    //тест преобразования из объекта в json
    @Test
    public void encodeDto() throws Exception {
        Point point = new Point();
        point.setLat(56, false);
        point.setLon(74, true);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        String pJson = point.toJson();
        assertTrue(pJson.contains("\"lat\":56"));
        assertTrue(pJson.contains("\"time\":"));
        System.out.println(pJson);
    }

    //тест преобразования из json в объект
    @Test
    public void decodeDto() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Point dto = mapper.readValue(json, Point.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1489900897458L, dto.getTime());
    }
}
