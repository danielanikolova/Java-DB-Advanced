package Mankind2;

public class Worker extends HumanImpl{
    private Double weekSalary;
    private Double workHoursPerDay;
    private Double salaryPerHour;


    public Worker(String firstName, String lastName) {
        super(firstName, lastName);
    }

   @Override
    public void setLastName(String lastName) throws IllegalArgumentException{

        int symbols = lastName.length();
        if (!lastName.matches("^[A-Z].+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");

        }
        else if(symbols<3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");

        }
        else {
            super.lastName = lastName;
        }
    }


    public Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) throws IllegalArgumentException{
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
        this.salaryPerHour = earnsMoneyPerHour(weekSalary, workHoursPerDay);
    }

    public Double getWeekSalary() {
        return this.weekSalary;
    }

    public void setWeekSalary(Double weekSalary) throws IllegalArgumentException{

        if (weekSalary>=10){
            this.weekSalary = weekSalary;
        }
        else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");

        }

    }

    public Double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public void setWorkHoursPerDay(Double workHoursPerDay) throws IllegalArgumentException{

        if (workHoursPerDay>=1 && workHoursPerDay<=12){
            this.workHoursPerDay = workHoursPerDay;
        }
        else {
            throw  new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");

        }

    }

    public Double getSalaryPerHour() {
        return this.salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }


    public Double earnsMoneyPerHour(Double weekSalary, Double workHoursPerDay){

        double moneyPerHour;
        double daySalary = weekSalary/7;
        moneyPerHour = daySalary/workHoursPerDay;

        return moneyPerHour;
    }

    @Override
    public String toString() {
        return  "First Name: " + firstName + "\n"+
                "Last Name: " + lastName + "\n"+
                "Week Salary: " + String.format("%.2f", weekSalary) + "\n"+
                "Hours per day: " + String.format("%.2f", getWorkHoursPerDay()) + "\n"+
                "Salary per hour: " + String.format("%.2f", salaryPerHour);
    }
}
