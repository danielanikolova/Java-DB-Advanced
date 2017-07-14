import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<String, String>();

        String input = scan.nextLine();

        while (input != "END"){

            String[] command = input.split(" ");

            switch (command[0]){
                case "A":
                    Add(phonebook, command);
                    break;
                case "S":
                    SearchPhonebook(phonebook, command);
                    break;

            }

            input = scan.nextLine();

        }
        return;
    }

    private static void SearchPhonebook(HashMap<String, String> phonebook,String[] command ){
        if (phonebook.containsKey(command[1]))
        {
            System.out.printf("%s -> %s\n",command[1], phonebook.get(command[1]) );

        }
        else
        {
            System.out.printf("Contact %s does not exist.\n", command[1]);
        }
    }

    private static void Add(HashMap<String, String> phonebook,String[] command){
        if (phonebook.containsKey(command[1]))
        {
            phonebook.put(command[1], command[2]);
        }
        else
        {
            phonebook.put(command[1], command[2]);
        }

    }
}
