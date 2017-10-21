package com.restapi.db.databaserestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (path="/personal")
public class PersonController {

    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    @Autowired // This means to get the bean called PersonRepository,
               // we will use it to handle the data
    private PersonRepository personRepository;

    @GetMapping(path="/all") // Map ONLY GET Requests
    public @ResponseBody ResponseEntity<?> getAllPersons() {
        ArrayList<personal_personalinfo> person = (ArrayList<personal_personalinfo>) personRepository.findAll();
        if ( (person == null) || (person.isEmpty()) ){
            logger.error("Person Details NOT FOUND");
            return new ResponseEntity(new CustomErrorType("Person Details not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @RequestMapping(value="/personById/{id}", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getSpecificPerson(@PathVariable Long id ) {
        ArrayList<personal_personalinfo> person = (ArrayList<personal_personalinfo>) personRepository.findById(id);
        if ( (person == null) || (person.isEmpty()) ){
            logger.error("Person with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Person with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @GetMapping(path="/personByLName/{lastName}")
    public @ResponseBody
    Iterable<personal_personalinfo> getPersonByLastName(@PathVariable String lastName ) {
        return personRepository.findByLastName(lastName);
    }

    @PostMapping(value="/addPerson", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addPerson(@RequestBody
                                       personal_personalinfo personalPersonalinfo ) {
        personRepository.save(personalPersonalinfo);
        return new ResponseEntity("Successfully login", new HttpHeaders(), HttpStatus.OK);
    }
}
