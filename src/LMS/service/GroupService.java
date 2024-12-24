package LMS.service;

import LMS.models.Group;

import java.util.List;

public interface GroupService {


    void addGroup(Group group);

    Group getByName(String name);

    void updateGroup(String name, Group newGroup);

    List<Group> getAllGroup();

    void deleteGroupByName(String name);
}