package BorderControl;

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();
        List<Birthable> birthables = new ArrayList<>();
        while (true){
            String line = scanner.nextLine();

            if (line.equals("End")){
                break;
            }

            String[] info = line.split(" ");

//            if (info.length == 2){
//                String name = info[0];
//                String id = info[1];
//
//                Identifiable robot = new RobotImpl(id, name);
//
//                identifiables.add(robot);
//            }
//            else if (info.length==3){
//                String name = info[0];
//                int age = Integer.parseInt(info[1]);
//                String id = info[2];
//
//                Identifiable citizen = new CitizenImpl(id, name, age);
//                identifiables.add(citizen);
//            }

            switch (info[0]){
                case "Citizen":
                    String id = info[3];
                    String name= info[1];
                    int age = Integer.parseInt(info[2]);
                    String birthday = info[4];

                    Birthable person = new CitizenImpl(id, name, age, birthday);
                    birthables.add(person);
                    Identifiable citizen = new CitizenImpl(id, name, age, birthday);
                    identifiables.add(citizen);
                    break;
                case "Pet":
                    String petName = info[1];
                    String petBirthday = info[2];
                    Pet pet = new PetImpl(petName, petBirthday);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String robotName= info[1];
                    String robotId = info[2];
                    Robot robot = new RobotImpl(robotId, robotName);
                    identifiables.add(robot);


                    break;

            }

        }


        String year = scanner.nextLine();

        for (Birthable birthable:birthables) {
            if (birthable.getBirthday().endsWith(year)){
                System.out.println(birthable.getBirthday());
            }

        }

//        String validId = scanner.nextLine();
//
//        for (Identifiable identifiable: identifiables ) {
//            if (identifiable.getId().endsWith(validId)){
//                System.out.println(identifiable.getId());
//            }
//        }

    }

}
