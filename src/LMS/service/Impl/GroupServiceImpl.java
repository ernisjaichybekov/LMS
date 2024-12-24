package LMS.service.Impl;

import LMS.dao.Impl.GroupDaoImpl;
import LMS.models.Group;
import LMS.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private final GroupDaoImpl groupDao;

    public GroupServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    public Group getByName(String name) {

        return groupDao.getByName(name);
    }

    @Override
    public void updateGroup(String name, Group newGroup) {
        groupDao.updateGroup(name, newGroup);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public void deleteGroupByName(String name) {
        groupDao.deleteGroupByName(name);
    }
}
