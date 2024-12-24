package LMS.service;

import LMS.models.Lesson;

public interface LessonService {

    void addLesson(String nameGroup, Lesson lesson);

    void getLessonByName(String groupName);

    void getAllLesson(String name);

    void deleteLesson(Long id);
}
