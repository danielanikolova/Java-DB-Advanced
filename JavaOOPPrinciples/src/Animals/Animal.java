package Animals;

public abstract class Animal implements Animals, SoundProducible{
    private String kind;
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) throws IllegalArgumentException{
        this.setKind(kind);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }



    @Override
    public String getKind() {
        return this.kind;
    }

    @Override
    public String produceSound() {
        return produceSound();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setKind(String kind){

            this.kind = kind;
    }

    public void setName(String name){
        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException("Invalid input!");
        }

            this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if (age>=0){
            this.age = age;
        }else {

            throw new IllegalArgumentException("Invalid input!");
        }

    }

    public void setGender(String gender)throws IllegalArgumentException{
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")){
            throw new IllegalArgumentException("Invalid input!");
        }else {
            this.gender = gender;
        }

       }

    @Override
    public String toString() {
        return getKind() +"\n" + this.getName()+" " + this.getAge()+" " + this.getGender() +
                "\n" + produceSound();
    }
}
