package com.evillcat.chorusapp.service.db;

import com.evillcat.chorusapp.model.Position;
import com.evillcat.chorusapp.repository.PositionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(@Autowired PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public void create(Position position) {
        positionRepository.save(position);
    }

    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    public Position getById(long id) {
        return positionRepository.getOne(id);
    }

    public void update(Position position) {
        positionRepository.update(position.getId(), position.getPosition());
    }

    public void delete(Position position) {
        positionRepository.delete(position);
    }
}
