package product.shop.dtoModels.viewModels.Problem4;


import com.google.gson.annotations.Expose;


import java.util.Set;

public class SoldProductsDto {
    @Expose
    private int count;
    @Expose
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
