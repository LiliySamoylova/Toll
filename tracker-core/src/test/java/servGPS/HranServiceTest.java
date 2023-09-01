package servGPS;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
class HranServiceTest {

    @Mock
    String result = "{\"shirota\":91.41367,\"dolgota\":53.09497,\"azimyt\":318.0}";

    @InjectMocks
    HranService hService = new HranService();
    @Test
    void putTest() throws InterruptedException, JsonProcessingException {
        List<Double> dataGpsList = new ArrayList<>();
        dataGpsList.add(91.41367);
        dataGpsList.add(53.09497);
        dataGpsList.add(318.0);
        hService.dataGps= dataGpsList;
        result = hService.put();
        assertEquals(result, hService.put());
    }


}