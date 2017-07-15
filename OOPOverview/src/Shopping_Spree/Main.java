package Shopping_Spree;

import java.util.*;

/**
 * Created by danie on 7/5/2017.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // read the first two lines to get people and products
        String inputPeopleAsString = scan.nextLine();

        if (inputPeopleAsString.equals("")){
            System.out.println("Name cannot be empty");
            return;
        }

        String[] inputPeople = inputPeopleAsString.split(";");

        // lists of persons and products
        LinkedHashMap<String, Person> persons = new LinkedHashMap<String, Person>();
        LinkedHashMap <String, Product>products = new LinkedHashMap<String, Product>();


        for (int i = 0; i < inputPeople.length ; i++) {
            String[] nameAndMoney = inputPeople[i].split("="); // split to couples by "="
            String name = nameAndMoney[0];
            int money = Integer.parseInt(nameAndMoney[1]);
            // get person data from couple
            Person currentPerson = new Person();

            if(nameAndMoney.equals("")){
                System.out.println("Name cannot be empty");
                return;
            }
            else if (money < 0) {

                System.out.println("Money cannot be negative");
                return;
            }
            else {
                currentPerson.setName(name);
                currentPerson.setMoney(money);

                // add person to collection
                persons.put(name, currentPerson);
            }
        }
        String inputProductsAsString = scan.nextLine();
        String[] inputProducts = inputProductsAsString.split(";");
        if (inputProductsAsString.equals("")){
            System.out.println("Name cannot be empty");
            return;
        }


        for (int i = 0; i < inputProducts.length; i++) {
            String[] nameAndPrice = inputProducts[i].split("="); // split to couple by "="
            String name = nameAndPrice[0];
            int price = Integer.parseInt(nameAndPrice[1]);

            Product currentProduct = new Product(name, price);

            if (nameAndPrice.equals("")){
                System.out.println("Name cannot be empty");
                return;
            }
            else if (price<0){
                System.out.println("Money cannot be negative");
                return;
            }

            products.put(name,currentProduct);
        }

        // read all lines after first two for orders
        String input = scan.nextLine();
        String personName;
        String productName;
        String operationName;
        while (!input.equals("END")){
            if (input.equals("")){
                return;
            }
            String [] purchase = input.split(" ");
            if (purchase.length<=1){
                System.out.println("Name cannot be empty");
                return;
            }
            personName = purchase[0];
            productName = purchase[1];

            //get the product the person is looking for
            Product product = products.get(productName);

            //get person financial status
            Person person = persons.get(personName);

            //check if money is enough
            if (person.getMoney() >= product.getCost())
            //initiate transaction
            {
                person.getProducts().add(productName);
                person.setMoney(person.getMoney() - product.getCost());

                operationName = " bought ";

            }
            else
            {
                operationName = " can't afford ";

            }

            System.out.println(personName + operationName + productName);
            input = scan.nextLine();
            if (input.equals("")){
                System.out.println("Name cannot be empty");
            }
        }

        for (Map.Entry<String, Person> entry : persons.entrySet()) {
            System.out.printf(entry.getValue().getName() + " - " );
            LinkedList<String> products1 = entry.getValue().getProducts();
            if (products1.size() == 0){
                System.out.print("Nothing bought");
            }

            for (int i = 0; i < products1.size(); i++) {
                System.out.print(products1.get(i));

                if (i < products1.size()-1) System.out.print( ", ");
            }

            System.out.println();

        }
    }
}
