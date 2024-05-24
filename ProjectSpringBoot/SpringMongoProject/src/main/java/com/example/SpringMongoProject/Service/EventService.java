package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Event;
import com.example.SpringMongoProject.Repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

	@Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(String id, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setTitle(eventDetails.getTitle());
            existingEvent.setStart(eventDetails.getStart());
            existingEvent.setEnd(eventDetails.getEnd());
            existingEvent.setDescription(eventDetails.getDescription());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsForToday() {
        LocalDate today = LocalDate.now();
        return eventRepository.findAll().stream()
            .filter(event -> {
                LocalDate eventDate = event.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return eventDate.equals(today);
            })
            .collect(Collectors.toList());
    }
}