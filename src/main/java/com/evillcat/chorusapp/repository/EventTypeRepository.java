package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {

    @Query("update EventType et set et.type = :type where et.id = :id")
    void update(@Param("id") Long id, @Param("type") String type);

}
