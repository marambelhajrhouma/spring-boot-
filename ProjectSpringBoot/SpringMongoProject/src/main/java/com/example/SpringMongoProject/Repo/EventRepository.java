package com.example.SpringMongoProject.Repo;


import com.example.SpringMongoProject.Entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}