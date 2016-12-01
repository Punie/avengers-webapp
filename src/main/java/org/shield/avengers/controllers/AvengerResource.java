package org.shield.avengers.controllers;

import org.shield.avengers.entities.Avenger;
import org.shield.avengers.repositories.AvengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/avengers")
public class AvengerResource
{
    @Autowired
    AvengerRepository avengerRepository;

    @CrossOrigin
    @GetMapping
    public List<Avenger> getAllAvengers ()
    {
        return avengerRepository.findAll ();
    }

    @CrossOrigin
    @PostMapping
    public Avenger createAvenger (@Valid @RequestBody Avenger avenger)
    {
        return avengerRepository.findOne (avengerRepository.save (avenger).getId ());
    }

    @CrossOrigin
    @GetMapping (value = "{id}")
    public ResponseEntity<Avenger> getAvengerById (@PathVariable ("id") String id)
    {
        Avenger avenger = avengerRepository.findOne (id);

        if (avenger == null)
            return new ResponseEntity<Avenger> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Avenger> (avenger, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping (value = "{id}")
    public ResponseEntity<Avenger> updateAvenger (@Valid @RequestBody Avenger avenger,
                                                  @PathVariable ("id") String id)
    {
        Avenger avengerData = avengerRepository.findOne (id);

        if (avengerData == null)
            return new ResponseEntity<Avenger> (HttpStatus.NOT_FOUND);

        avengerData.setAlias (avenger.getAlias ());
        avengerData.setFirstName (avenger.getFirstName ());
        avengerData.setLastName (avenger.getLastName ());
        avengerData.setPower (avenger.getPower ());
        avengerData.setImageURL (avenger.getImageURL ());
        avengerData.setAgent (avenger.getAgent ());

        Avenger updatedAvenger = avengerRepository.save (avengerData);

        return new ResponseEntity<Avenger> (updatedAvenger, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping (value = "{id}")
    public void removeAvenger (@PathVariable ("id") String id)
    {
        avengerRepository.delete (id);
    }
}
