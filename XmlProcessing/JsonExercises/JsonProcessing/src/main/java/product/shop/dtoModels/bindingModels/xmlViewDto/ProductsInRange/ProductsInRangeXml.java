package product.shop.dtoModels.bindingModels.xmlViewDto.ProductsInRange;


import com.google.gson.annotations.Expose;
import product.shop.dtoModels.viewModels.ProductInRangeDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeXml {


    @XmlElement(name = "product")
    public List<ProductInRangeDto> products;

    public ProductsInRangeXml() {
    }

    public List<ProductInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDto> products) {
        this.products = products;
    }
}
