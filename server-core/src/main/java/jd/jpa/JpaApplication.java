package jd.jpa;

import jd.dao.Person;
import jd.dao.repo.PersonRepository;
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
@EntityScan(basePackageClasses = Person.class)
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Person> allP;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = create("CLIENT", "123" );
        Person person2 = create("MANAGER", "456" );
        Person person3 = create("ROOT", "789" );
        log.info("=========== after create");
        read();

        update(person1, "Client", "012");

        log.info("=========== after update");
        read();

        delete(person1);
        log.info("=========== after delete");
        read();

    }

    private void delete(Person person) {
        personRepository.delete(person);
    }

    private void update(Person person, String name, String password) {
        person.setNamePerson(name);
        person.setPassword(password);
        personRepository.save(person);
    }

    private void read() {
        allP = (List<Person>) personRepository.findAll();

        if (allP.size() == 0) {
            log.info("NO RECORDS");
        } else {
            allP.stream().forEach(person -> log.info(person.toString()));
        }
    }

    private Person create(String name, String password) {
        Person person = new Person();
        person.setNamePerson(name);
        person.setPassword(password);
        return personRepository.save(person);
    }
}
