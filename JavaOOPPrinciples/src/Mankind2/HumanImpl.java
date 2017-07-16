package Mankind2;

public abstract class HumanImpl implements Human{

    protected String firstName;
    protected String lastName;


    public HumanImpl(String firstName, String lastName) throws  IllegalArgumentException{
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException{

        int symbols = firstName.length();
        if (!firstName.matches("^[A-Z].+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");

        }
        else if(symbols<4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");

        }
        else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) throws IllegalArgumentException {

        int symbols = lastName.length();
        if (!lastName.matches("^[A-Z].+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");

        }
        else if(symbols<3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");

        }



        this.lastName = lastName;
    }


}
