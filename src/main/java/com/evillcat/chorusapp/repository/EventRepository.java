package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.Event;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<List<Event>> findAllByEventType_Id(Long eventTypeId);

}
