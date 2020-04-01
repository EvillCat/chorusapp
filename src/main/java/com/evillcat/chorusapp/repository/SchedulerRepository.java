package com.evillcat.chorusapp.repository;

import com.evillcat.chorusapp.model.scheduler.SchedulerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<SchedulerModel, Long> {

}
