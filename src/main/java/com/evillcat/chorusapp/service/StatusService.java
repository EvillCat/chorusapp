package com.evillcat.chorusapp.service;

import com.evillcat.chorusapp.model.Status;
import com.evillcat.chorusapp.repository.StatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(@Autowired StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    public void create(Status status) {
        statusRepository.save(status);
    }

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status getById(long id) {
        return statusRepository.getOne(id);
    }

    public void update(Status status) {
        statusRepository.update(status.getId(), status.getStatus());
    }

    public void delete(Status status) {
        statusRepository.delete(status);
    }
}
