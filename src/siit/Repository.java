package siit;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Repository {

    static Logger LOGGER = Logger.getLogger(Repository.class.getName());

//      Compares last names A->Z
//    private NameComparator nameComparator = new NameComparator();
//    private Set<Student> listOfStudents = new TreeSet<>(nameComparator);

//      Compares years of birth(if equal) -> months(if equal) -> days, youngest first
    private AgeComparator ageComparator = new AgeComparator();
    private Set<Student> listOfStudents = new TreeSet<>(ageComparator);


    public void addStudent(Student student) {
        try {
            validateEmptyNames(student.getFirstName(), student.getLastName());
            validateCorrectYear(student.getYearOfBirth());
            validateGender(student.getGender());
            validatePositiveBirthDates(student.getDayOfBirth(), student.getMonthOfBirth());
            listOfStudents.add(student);
        } catch (ValidationException e){
            LOGGER.info(e.getMessage());
//            System.out.println(e.getMessage());
        }
    }

    public void removeStudent(String ID) {
        try {
            validateExistingID(ID);
        } catch (ValidationException e) {
            LOGGER.info(e.getMessage());
//            System.out.println(e.getMessage());
        }

        for (Student student: listOfStudents) {
            if(student.getID().equals(ID)) {
                listOfStudents.remove(student);
                break;
            }
        }
    }

    public void retrieveStudentWithAgeX(int age) {
        try {
            validatePositiveAge(age);
        } catch (ValidationException e) {
            LOGGER.info(e.getMessage());
//            System.out.println(e.getMessage());
        }

        int yearToLookFor = 2018-age;
        for (Student student: listOfStudents) {
            if(student.getYearOfBirth() == yearToLookFor) {
                System.out.println(student);
            }
        }
    }

    public void listStudents() {
        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

//    ValidationException
    private void validateEmptyNames(String firstName, String lastName) throws ValidationException{
        if(firstName.equals("") || lastName.equals("")) {
            throw new ValidationException("Name fields can't be empty!");
        }
    }

    private void validateCorrectYear(int year) throws ValidationException{
        if (year < 1900) {
            throw new ValidationException("Year of birth is not correct!");
        } else if(year > 2000) {
            throw new ValidationException("You have to be 18+ !");
        }
    }

    private void validateGender(String gender) throws ValidationException{
        gender = gender.toLowerCase();
        if (!gender.equals("m") && !gender.equals("f") && !gender.equals("male") && !gender.equals("female")) {
            throw new ValidationException("Please pick a valid gender format!");
        }
    }

    private void validateExistingID(String ID) throws ValidationException{
        for (Student student: listOfStudents) {
            if (ID.equals(student.getID())) {
                return;
            }
        }

        throw new ValidationException("Can't remove a non-existing student!");
    }

    private void validatePositiveAge(int age) throws ValidationException{
        if (age < 0) {
            throw new ValidationException("Age can't be negative!");
        }
    }

    private void validatePositiveBirthDates(int day, int month) throws ValidationException{
        for (Student student: listOfStudents) {
            if (student.getDayOfBirth() < 0) {
                throw new ValidationException("Day of Birth can't be negative!");
            }
            if (student.getMonthOfBirth() < 0 ) {
                throw new ValidationException("Month of Birth can't be negative!");
            }
        }
    }
}
