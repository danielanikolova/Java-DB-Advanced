package DefineAnInterfacePerson;

public class Citizen implements Person, Birthable, Identifiable {
    String name;
    int age;
    String ID;
    String birthdate;


    public Citizen(String name, int age, String ID, String birthdate) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.birthdate = birthdate;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Citizen() {
        super();
    }

    @Override
    public String getBirthdate() {
        return null;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

}
