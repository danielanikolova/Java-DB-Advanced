import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) {
        TreeMap<String, String> phonebook = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
        boolean canContinue = true;

        while (canContinue){


            String[] command = scan.nextLine().split(" ");

            switch (command[0]){
                case "A":
                    Add(phonebook, command);
                    break;
                case "S":
                    SearchPhonebook(phonebook, command);
                    break;
                case "ListAll":
                    ListAllPhonebook(phonebook);
                    break;
                case "END":
                    canContinue = false;
                    break;
            }

        }
        return;

    }

    private static void ListAllPhonebook(TreeMap<String, String> phonebook ){

        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println(key + " -> " + value);
        }
    }
    private static void SearchPhonebook(TreeMap<String, String> phonebook,String[] command ){
        if (phonebook.containsKey(command[1]))
        {
            System.out.printf("%s -> %s",command[1], phonebook.get(command[1]) );

        }
        else
        {
            System.out.printf("Contact %s does not exist.", command[1]);
        }
    }
    private static void Add(TreeMap<String, String> phonebook,String[] command){
        if (phonebook.containsKey(command[1]))
        {
            phonebook.put(command[1],command[2]);
        }
        else
        {
            phonebook.put(command[1], command[2]);
        }
    }

}
