package Mankind2;


public class Student extends HumanImpl{
    private String facultyNumber;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, String facultyNumber) throws IllegalArgumentException {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) throws IllegalArgumentException{

        int facultyNumberLength =facultyNumber.length();

        if (facultyNumberLength>=5 && facultyNumberLength<=10){
            this.facultyNumber = facultyNumber;
        }
        else {
          throw new IllegalArgumentException("Invalid faculty number!");

        }


    }

    @Override
    public String toString() {
        return "First Name: " + firstName+ "\n" +
                "Last Name: " + lastName + "\n"+
                "Faculty number: "+facultyNumber;
    }
}
