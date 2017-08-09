package product.shop.dtoModels.bindingModels.xmlViewDto.SuccessfullySoldProducts;

import product.shop.dtoModels.bindingModels.ProductNamePriceDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsXmlList {


    @XmlElement(name = "product")
    private Set<ProductNamePriceDto> soldProducts;

    public SoldProductsXmlList() {
    }

    public Set<ProductNamePriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductNamePriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
