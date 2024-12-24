package LMS.dao;

import LMS.models.Lesson;
import LMS.models.Student;

import java.util.List;

public interface StudentDao {
    void   savedDefaultAdmin();
    void addStudent(String groupName, Student student);
    void updateStudent(String email,String password, Student newStudent);
    void findStudentByFirstName(String name);
    List<Student> getAllStudentByGroupName(String groupName);
    List<Lesson> getAllStudentLesson(String email);
    void deleteStudent(String email);
    Student singIn(String email);
    void getAllLessonStudents(String email,String password);
    void updateAdmin(String adminEmail,Student newStudent);
}
