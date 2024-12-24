package LMS.models;

public class Lesson {
    private Long id;
    private String lessonName;
    private String taskDescription;
    private static long generateId = 1;

    public Lesson() {
        this.id = generateId++;
    }

    public Lesson(String lessonName, String taskDescription) {
        this.id = generateId++;
        this.lessonName = lessonName;
        this.taskDescription = taskDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return " \n        Lesson{" +
                "\nid =              " + id +"\n"+
                "\n lessonName =     " + lessonName + '\n' +
                " \ntaskDescription =" + taskDescription + '\n'
                + "\n";
    }
}
