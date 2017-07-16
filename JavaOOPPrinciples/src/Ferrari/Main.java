package Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {


        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String model = "488-Spider";

        Car currentCar = new Ferrari(model, name);

        System.out.printf("%s/%s/%s/%s", currentCar.getModel(),
                currentCar.useBrakes(),currentCar.pushTheGas(),
                currentCar.getDriver());

        String ferrariName = Ferrari.class.getSimpleName();

        String carInterface = Car.class.getSimpleName();

        boolean isCreated = Car.class.isInterface();

        if (!isCreated) {

            throw new IllegalClassFormatException("No interface created!");

        }

    }
}
