package LMS;

import LMS.dao.Impl.GroupDaoImpl;
import LMS.dao.Impl.LessonDaoImpl;
import LMS.dao.Impl.StudentDaoImpl;
import LMS.enums.Gender;
import LMS.enums.Role;
import LMS.models.Group;
import LMS.models.Lesson;
import LMS.models.Student;
import LMS.service.Impl.GroupServiceImpl;
import LMS.service.Impl.LessonServiceImpl;
import LMS.service.Impl.StudentServiceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanForStr = new Scanner(System.in);
    static Scanner scanForNumber = new Scanner(System.in);

    public static void main(String[] args) {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        GroupServiceImpl groupService = new GroupServiceImpl(groupDao);

        LessonDaoImpl lessonDao = new LessonDaoImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(lessonDao);

        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl(studentDao);
        while (true) {
            locolTime();
            System.out.println("Катталган болсонуз 1 басыныз,поролду унутуп калып озгортуу учун 2 басыныз! ");
            switch (checkValidCommand()) {

                case 1 -> {
                    System.out.println("Кируу учун электрондук почтанызды жана паролунузду жазыныз!");
                    System.out.print("электрондук почтанызды жазыныз: ");
                    String email = scanForStr.nextLine();
                    System.out.print("паролунузду жазыныз: ");
                    String password = scanForStr.nextLine();
                    studentService.savedDefaultAdmin();
                    try {
                        Student student = studentService.singIn(email);

                        assert student != null;
                        if (student.getRole().equals(Role.ADMIN)) {
                            adminMenu(studentService, groupService, lessonService);
                        } else if (student.getRole().equals(Role.USER)) {
                            userMenu(studentService);
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Почтанызды жазыныз: ");
                    String adminEmail = scanForStr.nextLine();

                    studentService.updateAdmin(adminEmail,addScanStudent());
                }
            }
        }
    }

    public static void userMenu(StudentServiceImpl studentService) {
        System.out.println("""
                 *** Бир команда танданыз ***
                   1 get all lesson students
                   2 Ad
                """);
        switch (checkValidCommand()) {
            case 1 -> {
                System.out.print("Почтанызды жазыныз: ");
                System.out.print("Пароль жазыныз: ");
                studentService.getAllLessonStudents(scanForStr.nextLine(), scanForStr.nextLine());
            }
            case 2 -> {

            }
            default -> System.out.println("invalid command!");
        }
    }

    public static void adminMenu(StudentServiceImpl studentService, GroupServiceImpl groupService, LessonServiceImpl lessonService) {
        boolean loop = true;
        while (loop) {
            System.out.println("""
                    *** Бир команда танданыз ***
                         0  exit
                         1  add new group
                         2  get group by name
                         3  update group name
                         4  get all groups
                         5  add new student to group
                         6  update student
                         7  find student by first name
                         8 get all students by group name
                         9 get all students lesson
                         10 delete student be email
                         11 add new lesson to group
                         12 get lesson by name
                         13 get all lesson by group name
                         14 delete lesson by id
                         15 delete group by name
                    """);

            switch (checkValidCommand()) {
                case 0 -> {
                    loop = false;
                }
                case 1 -> {
                    groupService.addGroup(addScanGroup());

                }
                case 2 -> {
                    System.out.print("Enter group name: ");
                    String name = scanForStr.nextLine();
                    groupService.getByName(name);
                }
                case 3 -> {
                    System.out.print("Озгортууну каалаган группанын атын жаз: ");
                    String name = scanForStr.nextLine();
                    groupService.updateGroup(name, addScanGroup());
                }
                case 4 -> {
                    System.out.println(groupService.getAllGroup());
                }
                case 5 -> {
                    System.out.print("Кайсыл группага студент кошосуз, ошол группанын атын жазыныз: ");
                    String name = scanForStr.nextLine();
                    studentService.addStudent(name, addScanStudent());
                }
                case 6 -> {
                    System.out.print("Почтанызды жазыныз: ");
                    String email = scanForStr.nextLine();
                    System.out.print("Пароль жазыныз: ");
                    String password = scanForStr.nextLine();
                    studentService.updateStudent(email, password, addScanStudent());
                }
                case 7 -> {
                    System.out.print("Студентин атын жазыныз: ");
                    studentService.findStudentByFirstName(scanForStr.nextLine());
                }
                case 8 -> {
                    System.out.print("Enter group name: ");
                    System.out.println(studentService.getAllStudentByGroupName(scanForStr.nextLine()));
                }
                case 9 -> {
                    System.out.print("Почтанызды жазыныз: ");
                    String email = scanForStr.nextLine();
                    System.out.println(studentService.getAllStudentLesson(email));
                }
                case 10 -> {
                    System.out.print("Кимди очуросуз , ошол адамдын почтасын жазыныз: ");

                }
                case 11 -> {
                    System.out.print("Группанын атын жазыныз: ");
                    String name = scanForStr.nextLine();
                    lessonService.addLesson(name, addScanLesson());
                }
                case 12 -> {
                    System.out.print("Enter lesson name: ");
                    String name = scanForStr.nextLine();
                    lessonService.getLessonByName(name);
                }
                case 13 -> {
                    System.out.print("Enter group name: ");
                    lessonService.getAllLesson(scanForStr.nextLine());
                }
                case 14 -> {
                    System.out.println("Enter lesson id");
                    lessonService.deleteLesson(scanForNumber.nextLong());
                }
                case 15 -> {
                    System.out.print("Enter group name: ");
                    groupService.deleteGroupByName(scanForStr.nextLine());
                }
                default -> {
                    System.out.println("invalid command!");
                }
            }
        }
    }

    public static Group addScanGroup() {
        Group group = new Group();
        System.out.print("Enter group mane: ");
        group.setGroupName(scanForStr.nextLine());
        System.out.print("Enter group description: ");
        group.setDescription(scanForStr.nextLine());
        group.setStudents(new ArrayList<>());
        group.setLessons(new ArrayList<>());
        return group;
    }

    public static Lesson addScanLesson() {
        Lesson lesson = new Lesson();
        System.out.print("Enter lesson name: ");
        lesson.setLessonName(scanForStr.nextLine());
        System.out.print("Enter group task description: ");
        lesson.setTaskDescription(scanForStr.nextLine());
        return lesson;
    }

    public static Student addScanStudent() {
        Student student = new Student();
        System.out.print("Enter student first name: ");
        student.setFirstName(scanForStr.nextLine());
        System.out.print("Enter student last name: ");
        student.setLastName(scanForStr.nextLine());
        System.out.print("Enter student email: ");
        student.setEmail(scanForStr.nextLine());
        System.out.print("Enter password: ");
        student.setPassword(scanForStr.nextLine());
        System.out.print("Enter reader gender (MAN,WOMAN): ");
        try {
            student.setGender(Gender.valueOf(scanForStr.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("invalid gender!");
            return addScanStudent();
        }
        student.setRole(Role.USER);

        return student;
    }

    public static void locolTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = localTime.format(formatter);
        String greeting;
        if (localTime.isBefore(LocalTime.of(6, 0))) {
            greeting = "Кутман түн";
        } else if (localTime.isBefore(LocalTime.of(12, 0))) {
            greeting = "Кутман таң";
        } else if (localTime.isBefore(LocalTime.of(18, 0))) {
            greeting = "Кутман күн";
        } else {
            greeting = "Кутман кеч";
        }
        System.out.println(greeting + "! Саат -> " + formattedTime);
    }

    public static int checkValidCommand() {
        int command = 0;
        boolean invalidCommand;
        System.out.print("command: ");
        do {
            try {
                command = new Scanner(System.in).nextInt();
                invalidCommand = false;
            } catch (InputMismatchException e) {
                invalidCommand = true;
                System.out.print("invalid command. Enter valid command: ");
            }
        } while (invalidCommand);
        return command;
    }

    public static String isValidData(String label, String pattern) {
        System.out.printf("Enter the %s", label);
        String data;

        do {
            data = new Scanner(System.in).nextLine();
            if (!data.matches(pattern)) {
                System.out.printf("invalid %s. Enter valid %s: ", label, label);
            }

        } while (!data.matches(pattern));
        return data;
    }
}