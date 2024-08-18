package com.bankiapp.services;

import com.bankiapp.dto.GroupDto;
import com.bankiapp.entities.Group;

import java.util.List;

public interface GroupService {
    Group create(GroupDto groupDto);
    Group getOne(long id);
    List<Group> findAll();
}
