package siit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.setLevel(Level.FINEST);

        Student student1 = new Student("A", "Mazare", 4, 2, 1998, "female", "112");
        Student student2 = new Student("B", "Heghes", 2, 2, 1900, "MALE", "111");

        Repository repository = new Repository();

        addStudent(student1, repository);
        addStudent(student2, repository);
        listStudents(repository);

        retrieveStudentWithAgeX(-20, repository);
        retrieveStudentWithAgeX(20, repository);

        removeStudentByID("1123", repository);
        removeStudentByID("112", repository);

    }

    public static void addStudent(Student student, Repository repository) {
        repository.addStudent(student);
    }

    public static void listStudents(Repository repository) {
        System.out.println("=== List all students ===");
        repository.listStudents();
    }

    public static void retrieveStudentWithAgeX(int age, Repository repository) {
        System.out.println("=== List students by age ===");
        repository.retrieveStudentWithAgeX(age);
    }

    public static void removeStudentByID(String ID, Repository repository) {
        repository.removeStudent(ID);
    }
}
