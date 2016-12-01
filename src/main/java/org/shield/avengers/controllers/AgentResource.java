package org.shield.avengers.controllers;

import org.shield.avengers.entities.Agent;
import org.shield.avengers.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/agents")
public class AgentResource
{
    @Autowired
    AgentRepository agentRepository;

    @CrossOrigin
    @GetMapping
    public List<Agent> getAllAgents ()
    {
        return agentRepository.findAll ();
    }

    @CrossOrigin
    @PostMapping
    public Agent createAgent (@Valid @RequestBody Agent agent)
    {
        return agentRepository.save (agent);
    }

    @CrossOrigin
    @GetMapping (value = "{id}")
    public ResponseEntity<Agent> getAgentById (@PathVariable ("id") String id)
    {
        Agent agent = agentRepository.findOne (id);

        if (agent == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<> (agent, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping (value = "{id}")
    public ResponseEntity<Agent> updateAvenger (@Valid @RequestBody Agent agent,
                                                  @PathVariable ("id") String id)
    {
        Agent agentData = agentRepository.findOne (id);

        if (agentData == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

        agentData.setFirstName (agent.getFirstName ());
        agentData.setLastName (agent.getLastName ());
        agentData.setAlias (agent.getAlias ());
        agentData.setDescription (agent.getDescription ());
        agentData.setImageURL (agent.getImageURL ());

        Agent updatedAgent = agentRepository.save (agentData);

        return new ResponseEntity<> (updatedAgent, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping (value = "{id}")
    public void removeAvenger (@PathVariable ("id") String id)
    {
        agentRepository.delete (id);
    }
}
