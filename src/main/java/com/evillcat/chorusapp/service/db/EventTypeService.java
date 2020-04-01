package com.evillcat.chorusapp.service.db;

import com.evillcat.chorusapp.model.EventType;
import com.evillcat.chorusapp.repository.EventTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    public void addEventType(EventType eventType) {
        eventTypeRepository.save(eventType);
    }

    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public void updateEventType(EventType eventType) {
        eventTypeRepository.update(eventType.getId(), eventType.getType());
    }

    public void deleteEventType(EventType eventType) {
        eventTypeRepository.delete(eventType);
    }
}
