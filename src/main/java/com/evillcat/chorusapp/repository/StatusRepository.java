package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("update Status s set s.status = :status where s.id = :id")
    void update(@Param("id") Long id, @Param("status") String status);

}
