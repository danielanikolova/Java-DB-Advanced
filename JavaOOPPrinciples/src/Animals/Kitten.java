package Animals;


public class Kitten extends Cat{
    public Kitten(String name, int age) {
        super(name, age, "Female");
        super.setKind("Kitten");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
