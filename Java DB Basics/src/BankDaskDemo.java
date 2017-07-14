import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankDaskDemo {
    public static void main(String[] args) {

        Map<Integer, DefineBankAccountClass> accounts = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String commandLine = scan.nextLine().toLowerCase();

        while (!commandLine.equals("end")){

            String[] tokens = commandLine.split("\\s+");

            switch (tokens[0]){
                case "create" :{

                    execDeposit (tokens, accounts);
                    break;
                }
                case "deposit" :{

                    execCreate (tokens, accounts);
                    break;
                }

                case "print" :{

                    execPrint (tokens, accounts);
                    break;
                }

            }
            commandLine = scan.nextLine().toLowerCase();
        }
            System.out.println("Good bye have a nice day!");
    }

    private static void execPrint(String[] tokens, Map<Integer, DefineBankAccountClass> accounts) {
        Integer id = Integer.parseInt(tokens[1]);
        DefineBankAccountClass acc = accounts.get(id);
        if (acc!= null){
            System.out.println(acc + "balance" + acc.getBalance());

        }

    }

    private static void execDeposit(String[] tokens, Map<Integer, DefineBankAccountClass> accounts) {
        Integer id = Integer.parseInt(tokens[1]);
        DefineBankAccountClass acc = accounts.get(id);
        if (acc!= null){
            Double amount  = Double.parseDouble(tokens[2]);

        }

    }

    private static void execCreate(String[] tokens, Map<Integer, DefineBankAccountClass> accounts) {
        Integer id = Integer.parseInt(tokens[1]);

        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
            return;
        }

        DefineBankAccountClass acc =
                new DefineBankAccountClass(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        accounts.put(id,acc);
    }
}
