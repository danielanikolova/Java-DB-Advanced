package Shopping_Spree;

import java.util.LinkedList;

/**
 * Created by danie on 7/5/2017.
 */
public class Person {

    private String name;
    private int money;
    private LinkedList<String> products;

    public Person() {
       products = new LinkedList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public LinkedList<String> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<String> products) {
        this.products = products;
    }


}
