package jdev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jdev on 26.03.2017.
 */
public class PropMain {
    public static void main(String... args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropContext.class);
    }
}
