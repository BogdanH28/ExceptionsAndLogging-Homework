package siit;

public class Student {

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String gender;
    private String ID;


    public Student(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth, String gender, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
