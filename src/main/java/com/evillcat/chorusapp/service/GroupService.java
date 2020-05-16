package com.evillcat.chorusapp.service;

import com.evillcat.chorusapp.model.Group;
import com.evillcat.chorusapp.repository.GroupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public void create(Group group) {
        groupRepository.save(group);
    }

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group getById(long id) {
        return groupRepository.getOne(id);
    }

    public void update(Group group) {
        groupRepository.update(group.getId(), group.getGroup());
    }

    public void delete(Group group) {
        groupRepository.delete(group);
    }
}
