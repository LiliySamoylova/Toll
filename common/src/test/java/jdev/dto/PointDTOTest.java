package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PointDTOTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1489900897458}";
    private String autoId = "o567gfd";

    //тест преобразования из объекта в json
    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

    //тест преобразования из json в объект
    @Test
    public void decodeDto() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1489900897458L, dto.getTime());
    }
}
