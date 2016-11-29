package org.shield.avengers.repositories;

import org.shield.avengers.entities.Avenger;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvengerRepository extends MongoRepository<Avenger, String>
{
    List<Avenger> findAll ();
    Avenger findOne (String id);
    Avenger save (Avenger avenger);
    void delete (Avenger avenger);
}
