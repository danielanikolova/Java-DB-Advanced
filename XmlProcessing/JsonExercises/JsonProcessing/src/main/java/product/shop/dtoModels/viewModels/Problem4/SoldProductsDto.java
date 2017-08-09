package product.shop.dtoModels.viewModels.Problem4;


import com.google.gson.annotations.Expose;


import javax.xml.bind.annotation.*;
import java.util.Set;
@XmlRootElement(name = "sold-prodcts")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsDto {
    @Expose
    @XmlAttribute(name = "count")
    private int count;
    @Expose
    @XmlElement(name = "product")
    private Set<ProductNamePriceViewDto> products;

    public SoldProductsDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<ProductNamePriceViewDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductNamePriceViewDto> products) {
        this.products = products;
        this.count = products.size();
    }
}
