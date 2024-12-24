package LMS.dao.Impl;

import LMS.dao.GroupDao;

import LMS.models.Group;


import java.util.List;

public class GroupDaoImpl implements GroupDao {



    @Override
    public void addGroup(Group group) {

        DateBase.baseGroup.add(group);
        System.out.println(group+"группа ийгиликтуу сакталды!");
    }

    @Override
    public Group getByName(String name) {
        for (Group group : DateBase.baseGroup) {
            if ((group.getGroupName().equalsIgnoreCase(name))){
                System.out.println(group);
                break;
            }
        }

        return null;
    }

    @Override
    public void updateGroup(String name, Group newGroup) {
        for (Group group : DateBase.baseGroup) {
            if(group.getGroupName().equals(name)){
                group.setGroupName(newGroup.getGroupName());
                group.setDescription(newGroup.getDescription());
                group.setLessons(newGroup.getLessons());
                group.setStudents(newGroup.getStudents());
                System.out.println("Группа ийгиликтуу озгорулду!");
                break;
            }
        }
    }

    @Override
    public List<Group> getAllGroup() {
        return DateBase.baseGroup;
    }

    @Override
    public void deleteGroupByName(String name) {
        for (Group group : DateBase.baseGroup) {
            if(group.getGroupName().equalsIgnoreCase(name)){
                DateBase.baseGroup.remove(group);
                System.out.println(group+"Ийгиликтуу очурулду!");
                break;
            }
        }
    }
}
