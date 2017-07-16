package Animals;

public class Tomcat extends Cat{
    public Tomcat(String name, int age) {
        super(name, age, "Male");
        super.setKind("Tomcat");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
