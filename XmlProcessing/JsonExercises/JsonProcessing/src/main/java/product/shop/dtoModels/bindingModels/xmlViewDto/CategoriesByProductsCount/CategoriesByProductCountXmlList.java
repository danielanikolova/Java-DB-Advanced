package product.shop.dtoModels.bindingModels.xmlViewDto.CategoriesByProductsCount;

import product.shop.dtoModels.viewModels.CategoryByProductsCountDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductCountXmlList {

    @XmlElement(name = "category")
    private List<CategoryByProductsCountDto> products;

    public CategoriesByProductCountXmlList() {
    }

    public List<CategoryByProductsCountDto> getProducts() {
        return products;
    }

    public void setProducts(List<CategoryByProductsCountDto> products) {
        this.products = products;
    }
}
