package LMS.dao;

import LMS.models.Lesson;

public interface LessonDao {
    void addLesson(String nameGroup, Lesson lesson);

    void getLessonByName(String name);

    void getAllLesson(String groupName);

    void deleteLesson(Long id);
}
