package product.shop.dtoModels.bindingModels.xmlDtos;

import product.shop.dtoModels.bindingModels.Add.ProductAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsImportXml {

    @XmlElement(name = "product")
    private List<ProductAddDto> productAddDtos;

    public ProductsImportXml() {
    }

    public List<ProductAddDto> getProductAddDtos() {
        return productAddDtos;
    }

    public void setProductAddDtos(List<ProductAddDto> productAddDtos) {
        this.productAddDtos = productAddDtos;
    }
}
