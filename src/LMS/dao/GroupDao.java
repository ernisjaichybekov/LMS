package LMS.dao;

import LMS.models.Group;
import LMS.models.Student;

import java.util.List;

public interface GroupDao {
    void addGroup(Group group);

    Group getByName(String name);

    void updateGroup(String name, Group newGroup);

    List<Group> getAllGroup();

    void deleteGroupByName(String name);
}