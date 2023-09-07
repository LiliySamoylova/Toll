package jd.jpa;

import jd.dao.Gps;
import jd.dao.repo.RocketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("jd.dao")
@EntityScan(basePackageClasses = Gps.class)
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Gps> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    RocketRepository rocketRepository;

    @Override
    public void run(String... args) throws Exception {
        read();

        Gps soyuz = create( "Soyuz");
        Gps falcon = create( "Falcon");
        Gps angara = create("Angara");
        log.info("=========== after create");
        read();

        update(soyuz, "Soyuz 2");
        update(falcon, "Falcon 9");
        update(angara, "Angara A5");

        log.info("=========== after update");
        read();

        delete(soyuz);
        log.info("=========== after delete 1");
        read();

        delete(falcon);
        log.info("=========== after delete 2");
        read();

        delete(angara);
        log.info("=========== after delete 3");
        read();

        delete(angara);
        log.info("=========== after delete 4");
        read();
    }

    private void delete(Gps gps) {
        rocketRepository.delete(gps);
    }

    private void update(Gps gps, String model) {
        gps.setModel(model);
        rocketRepository.save(gps);
    }

    private void read() {
         all = (List<Gps>) rocketRepository.findAll();

         if (all.size() == 0) {
             log.info("NO RECORDS");
         } else {
             all.stream().forEach(gps -> log.info(gps.toString()));
         }
    }

    private Gps create(String model) {
        Gps gps = new Gps();
        gps.setModel(model);
        return rocketRepository.save(gps);
    }
}
