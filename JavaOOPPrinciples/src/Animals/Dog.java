package Animals;

public class Dog extends Animal{


    public Dog(String name, int age, String gender) {
        super( name, age, gender);
        super.setKind("Dog");
    }



    @Override
    public String produceSound() {
        return "BauBau";
    }


}
