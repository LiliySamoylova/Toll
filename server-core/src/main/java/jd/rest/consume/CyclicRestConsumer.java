package jd.rest.consume;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;


public class CyclicRestConsumer {

    public static void main(String... args) throws IOException, InterruptedException {
        while (true) {
            String response = IOUtils.toString(new URL("http://localhost:8080/counter?name=The+Who"), "UTF8");
            System.out.println(response);

            response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4,lon34.6"), "UTF8");
            System.out.println(response);

            response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4"), "UTF8");
            System.out.println(response);

            //неверный запрос будет отвергнут, отсутствует переменная location
            try {
                response = IOUtils.toString(new URL("http://localhost:8080/coords"), "UTF8");
                System.out.println(response);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("==================================================");
                Thread.sleep(2000);

            }
        }
    }
}
