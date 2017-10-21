package com.restapi.db.databaserestapi;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandLineRunner implements CommandLineRunner{

    private final PersonRepository repository;

    private static final Logger log = LoggerFactory.getLogger(DatabaseRestapiApplication.class);

    public PersonCommandLineRunner (PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("PRAX::: checking how many times you are executing this....");
        // save a couple of customers
        /*
        repository.save(new personal_personalinfo("Jack", "Bauer", " ", "j.g@email.com", "M" , 23));
        repository.save(new personal_personalinfo("Chloe", "O'Brian", " ", "c.u@gmail.com", "M", 23));
        repository.save(new personal_personalinfo("Kim", "Bauer", " ", "r.f@gmail.com","F", 21));
        */
        // fetch all customers
        log.info("personal_personalinfo found with findAll():");
        log.info("-------------------------------");
        log.info("PRAX:::: \n"+ repository.findAll());
        for (personal_personalinfo personalpersonalinfo : repository.findAll()) {
            log.info(personalpersonalinfo.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        personal_personalinfo personalpersonalinfo = repository.findOne( 50L);
        log.info("personal_personalinfo found with findOne(1L):");
        log.info("--------------------------------");
        log.info(personalpersonalinfo.toString());
        log.info("");

        // fetch customers by last name
        log.info("personal_personalinfo found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        for (personal_personalinfo bauer : repository.findByLastName("Bauer")) {
            log.info(bauer.toString());
        }
        log.info("");
    }
}
