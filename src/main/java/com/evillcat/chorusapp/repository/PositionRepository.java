package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("update Position p set p.position = :position where s.id = :id")
    void update(@Param("id") Long id, @Param("position") String position);
}
