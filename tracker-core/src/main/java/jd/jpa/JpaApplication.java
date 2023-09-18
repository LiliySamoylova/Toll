package jd.jpa;


import jd.dao.HranData;
import jd.dao.repo.HranDataRepository;
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
@EntityScan(basePackageClasses = HranData.class)
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<HranData> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    HranDataRepository HranDataRepository;

    @Override
    public void run(String... args) throws Exception {
        //read();

        HranData gps1 = create( 91.41367, 53.09497, 318.0);
        HranData gps2 = create( 91.47, 53.07, 319.0);
        HranData gps3 = create(91.05, 53.97, 320.0);
        log.info("=========== after create");
        read();

        update(gps1, 92.7, 58.2, 321.0);

        log.info("=========== after update");
        read();

        delete(gps1);
        log.info("=========== after delete");
        read();

    }

    private void delete(HranData gps) {
        HranDataRepository.delete(gps);
    }

    private void update(HranData gps, Double shirota, Double dolgota, Double azimyt) {
        gps.setShirota(shirota);
        gps.setDolgota(dolgota);
        gps.setAzimyt(azimyt);
        HranDataRepository.save(gps);
    }

    private void read() {
         all = (List<HranData>) HranDataRepository.findAll();

         if (all.size() == 0) {
             log.info("NO RECORDS");
         } else {
             all.stream().forEach(gps -> log.info(gps.toString()));
         }
    }

    private HranData create(Double shirota, Double dolgota, Double azimyt) {
        HranData gps = new HranData();
        gps.setShirota(shirota);
        gps.setDolgota(dolgota);
        gps.setAzimyt(azimyt);
        return HranDataRepository.save(gps);
    }
}
