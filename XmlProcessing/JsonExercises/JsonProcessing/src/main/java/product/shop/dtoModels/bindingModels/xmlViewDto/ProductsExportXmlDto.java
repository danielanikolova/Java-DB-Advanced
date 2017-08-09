package product.shop.dtoModels.bindingModels.xmlViewDto;

import product.shop.dtoModels.viewModels.ProductViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsExportXmlDto {

    @XmlElement(name = "product")
    private List<ProductViewDto> productViewDtos;

    public ProductsExportXmlDto() {
    }

    public List<ProductViewDto> getProductViewDtos() {
        return productViewDtos;
    }

    public void setProductViewDtos(List<ProductViewDto> productViewDtos) {
        this.productViewDtos = productViewDtos;
    }
}
