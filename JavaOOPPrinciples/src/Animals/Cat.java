package Animals;

public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
        super.setKind("Cat");
    }



    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
