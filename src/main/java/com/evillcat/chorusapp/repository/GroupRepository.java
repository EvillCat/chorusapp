package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("update Group g set g.group = :group where g.id = :id")
    void update(@Param("id") Long id, @Param("group") String group);

}
