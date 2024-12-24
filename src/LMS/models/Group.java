package LMS.models;

import java.util.List;

public class Group {
    private Long id;
    private String groupName;
    private String description;
    private List<Lesson> lessons;
    private List<Student> students;
    private static long generateId = 1;

    public Group() {
        this.id = generateId++;
    }

    public Group(String groupName, String description) {
        this.id = generateId++;
        this.groupName = groupName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "  \n          Group        \n" +
                "\n    id         : " + id +"\n"+
                "\n groupName    : " + groupName + "\n" +
                "\n description= : " + description + "\n" +
                "\n lessons      : " + lessons +"\n"+
                "\n students     : " + students
                +"\n";
    }
}