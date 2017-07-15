package Shopping_Spree;

/**
 * Created by danie on 7/5/2017.
 */
public class Product {
    private int cost;
    private String name;

    public Product(String name,int cost) {

        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
