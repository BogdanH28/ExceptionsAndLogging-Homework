package siit;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if(s2.getYearOfBirth()-s1.getYearOfBirth() != 0) {
            return s2.getYearOfBirth() - s1.getYearOfBirth();
        } else if(s2.getMonthOfBirth()-s1.getMonthOfBirth() != 0) {
            return s2.getMonthOfBirth()-s1.getMonthOfBirth();
        } else {
            return s2.getDayOfBirth()-s1.getDayOfBirth();
        }
    }
}
