package Animals;

public class Frog extends Animal{
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
        super.setKind("Frog");
    }



    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
