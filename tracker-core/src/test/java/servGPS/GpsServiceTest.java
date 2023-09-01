package servGPS;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
class GpsServiceTest {
    private List<Double> dataGps, result;


    @Test
    public void callFromInitTest() {
        GpsService gpsService = new GpsService(91.41367, 53.09497, 318.0);
        dataGps = new ArrayList<>();
        dataGps.add(91.41367);
        dataGps.add(53.09497);
        dataGps.add(318.0);
        result = gpsService.callFromInit();
        assertNotNull(result);
        assertEquals(dataGps, result);
    }
}