package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private  String name;
    private BigDecimal price;
    private Set<Sale> products;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "product")
    public Set<Sale> getProducts() {
        return products;
    }

    public void setProducts(Set<Sale> products) {
        this.products = products;
    }


}
