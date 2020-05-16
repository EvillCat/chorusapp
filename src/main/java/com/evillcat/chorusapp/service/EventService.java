package com.evillcat.chorusapp.service;

import com.evillcat.chorusapp.model.Event;
import com.evillcat.chorusapp.repository.EventRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    /**
     *
     * @param event
     * @return null если событие не содержится в базе.
     */
    public Event updateEvent(Event event) {
        Optional optional = eventRepository.findById(event.getId());
        if (optional.isPresent()) {
            eventRepository.save(event);
            return event;
        } else {
            return null;
        }
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     *
     * @param eventTypeId
     * @return если событий данного типа не содержится, вернёт пустую коллекцию.
     */
    public List<Event> getAllEventsByType(long eventTypeId) {
        Optional<List<Event>> optionalEvents = eventRepository.findAllByEventType_Id(eventTypeId);
        if (optionalEvents.isPresent()) {
            return optionalEvents.get();
        } else {
            return Collections.emptyList();
        }
    }

    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }



}
