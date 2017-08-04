package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;

import java.util.List;

public class SoldProductsCountAndInfo {

    @Expose
    private Integer count;

    @Expose
    private List<ProductNamePriceViewDto> products;



    public SoldProductsCountAndInfo() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductNamePriceViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNamePriceViewDto> products) {
        this.products = products;
    }
}
