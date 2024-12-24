package LMS.service.Impl;

import LMS.dao.Impl.StudentDaoImpl;
import LMS.models.Lesson;
import LMS.models.Student;
import LMS.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDaoImpl studentDao;

    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void savedDefaultAdmin() {
        studentDao.savedDefaultAdmin();
    }

    @Override
    public void addStudent(String groupName, Student student) {
        studentDao.addStudent(groupName, student);
    }

    @Override
    public void updateStudent(String email, String password, Student newStudent) {
        studentDao.updateStudent(email, password, newStudent);
    }

    @Override
    public void findStudentByFirstName(String name) {
        studentDao.findStudentByFirstName(name);
    }

    @Override
    public List<Student> getAllStudentByGroupName(String groupName) {
        return studentDao.getAllStudentByGroupName(groupName);
    }

    @Override
    public List<Lesson> getAllStudentLesson(String email) {
        return studentDao.getAllStudentLesson(email);
    }


    @Override
    public void deleteStudent(String email) {
        studentDao.deleteStudent(email);
    }

    @Override
    public Student singIn(String email ) {
        return studentDao.singIn(email);
    }

    @Override
    public void getAllLessonStudents(String email, String password) {
        studentDao.getAllLessonStudents(email,password);
    }

    @Override
    public void updateAdmin(String adminEmail,Student newStudent) {
        studentDao.updateAdmin(adminEmail,newStudent);
    }
}
