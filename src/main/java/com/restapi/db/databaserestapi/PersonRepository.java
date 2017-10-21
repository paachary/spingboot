package com.restapi.db.databaserestapi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<personal_personalinfo, Long> {

    List<personal_personalinfo> findByLastName(String lastName);
    List<personal_personalinfo> findById(Long id);
}
