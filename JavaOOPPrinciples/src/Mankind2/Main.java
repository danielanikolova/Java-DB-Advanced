package Mankind2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] studentInfo = scanner.nextLine().split(" ");
        String[] workerInfo = scanner.nextLine().split(" ");
        Student current = null;
        try {
            current = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return;
        }



        Worker currentWorker = null;
        try{
            currentWorker  = new Worker(workerInfo[0],workerInfo[1],
                    Double.parseDouble(workerInfo[2]), Double.parseDouble(workerInfo[3]));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }


        System.out.println(current);
        System.out.println();


        System.out.println(currentWorker);

    }
}
