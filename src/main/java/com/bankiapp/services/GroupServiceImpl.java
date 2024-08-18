package com.bankiapp.services;

import com.bankiapp.dto.GroupDto;
import com.bankiapp.entities.Group;
import com.bankiapp.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    GroupServiceImpl(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
     }

    @Override
    public Group create(GroupDto groupDto) {
        Group group = new Group();
        group.setNomGroup(groupDto.getNomGroup());
        return this.groupRepository.save(group);
    }

    @Override
    public Group getOne(long id) {
        return this.groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }
}
