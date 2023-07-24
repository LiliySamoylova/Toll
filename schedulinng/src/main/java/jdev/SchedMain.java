package jdev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchedMain {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingContext.class);
    }
}
