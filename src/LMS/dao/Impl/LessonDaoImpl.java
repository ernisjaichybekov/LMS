package LMS.dao.Impl;

import LMS.dao.LessonDao;
import LMS.models.Group;
import LMS.models.Lesson;

public class LessonDaoImpl implements LessonDao {
    @Override
    public void addLesson(String nameGroup, Lesson lesson) {
        for (Group group : DateBase.baseGroup) {
            if (group.getGroupName().equalsIgnoreCase(nameGroup)) {
                group.getLessons().add(lesson);
                System.out.println(lesson + " Ийгиликтуу сакталды!");
                break;
            }
        }

    }

    @Override
    public void getLessonByName(String name) {
        for (Group group : DateBase.baseGroup) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getLessonName().equalsIgnoreCase(name)) {
                    System.out.println(lesson);
                    break;
                }
            }
        }


    }

    @Override
    public void getAllLesson(String groupName) {
        for (Group group : DateBase.baseGroup) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                System.out.println(group.getLessons());
                break;
            }
        }
    }

    @Override
    public void deleteLesson(Long id) {
        for (Group group : DateBase.baseGroup) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getId().equals(id)) {
                    group.getLessons().remove(lesson);
                    System.out.println("Ийгиликтуу очурулду!");
                    break;
                }
            }
        }
    }
}
