package com.example.lab3.service;

import com.example.lab3.entity.Group;
import com.example.lab3.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group get(long id) {
        return groupRepository.get(id);
    }
}
