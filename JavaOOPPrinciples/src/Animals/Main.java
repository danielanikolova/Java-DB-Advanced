package Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();
        String lineInfo = scanner.nextLine();
        String name;
        int age;
        String gender;

        boolean cancontinue = true;

        while (cancontinue) {

            String[] line = lineInfo.split(" ");
            if (line.length < 3) {
                System.out.println("Invalid input!");
            } else {

                name = line[0];
                age = Integer.parseInt(line[1]);
                gender = line[2];


                switch (animal.toLowerCase()) {
                    case "cat":
                        try {
                            Animal currentCat = new Cat(name, age, gender);
                            System.out.println(currentCat.toString());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    case "dog":
                        try {
                            Animal currentDog = new Dog(name, age, gender);
                            System.out.println(currentDog.toString());
                        }
                        catch (IllegalArgumentException e){
                            System.out.println("Invalid input!");
                        }
                        break;

                    case "frog":
                        try {
                            Animal currentFrog = new Frog(name, age, gender);
                            System.out.println(currentFrog.toString());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid input!");

                        }
                        break;

                    case "kitten":
//                        if (!gender.toLowerCase().equals("female")) {
//                            System.out.println("Invalid input!");
//                        } else {
                            try {
                                Animal currentKitten = new Kitten(name, age);
                                System.out.println(currentKitten.toString());
                            }catch (IllegalArgumentException ex){
                                System.out.println("Invalid input!");
                            }
//                        }
                        break;
                    case "tomcat":
//                        if (!gender.toLowerCase().equals("male")) {
//                            System.out.println("Invalid input!");
//                        } else {
                            try {
                                Animal currentTomcat = new Tomcat(name, age);
                                System.out.println(currentTomcat.toString());
                            }catch (IllegalArgumentException ex){
                                System.out.println("Invalid input!");
                            }
//                        }
                        break;
                    default:
                        System.out.println("Invalid input!");
                }
            }


            animal = scanner.nextLine();
            if (animal.equals("Beast!")) {
                return;
            } else {
                lineInfo = scanner.nextLine();
            }

        }

        }


    }
