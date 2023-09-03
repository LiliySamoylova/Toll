package servGPS;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.codemodel.JOp.eq;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OtprServiceTest {
    @Mock
    RestTemplate restTemplate=mock(RestTemplate.class);
    String result = "{\"shirota\":91.41367,\"dolgota\":53.09497,\"azimyt\":318.0}";

    HranService hranService = mock(HranService.class);

    OtprService otprService = new OtprService();// = mock(OtprService.class);


    @Test
    void postRestT() throws IOException, InterruptedException {
        String url = "http://localhost:8080/gps";
        Mockito.when(hranService.take()).thenReturn(result);
        otprService.data = hranService.take();
        String restOtpr;

        Mockito.when(restTemplate.postForObject(url, String.class, String.class)).thenReturn(new String()); //result
        otprService.gpsData = restTemplate.postForObject(url, otprService.data, String.class);

        // Ошибка.... в класс OtprService 47 строка.
        restOtpr = otprService.postRestT();
        System.out.println(otprService.postRestT());
        assertNotNull(restOtpr);
    }
}