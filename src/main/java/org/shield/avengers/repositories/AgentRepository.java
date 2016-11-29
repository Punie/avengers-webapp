package org.shield.avengers.repositories;

import org.shield.avengers.entities.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AgentRepository extends MongoRepository<Agent, String>
{
    List<Agent> findAll ();
    Agent findOne (String id);
    Agent save (Agent agent);
    void delete (Agent agent);
}
