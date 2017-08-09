package product.shop.dtoModels.bindingModels.xmlViewDto.SuccessfullySoldProducts;


import product.shop.dtoModels.viewModels.SellerWithProductsDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerWithProductsXmlList {

    @XmlElement(name = "user")
    private List<SellerWithProductsDto> sellerWithProductsDtoList;

    public SellerWithProductsXmlList() {
    }

    public List<SellerWithProductsDto> getSellerWithProductsDtoList() {
        return sellerWithProductsDtoList;
    }

    public void setSellerWithProductsDtoList(List<SellerWithProductsDto> sellerWithProductsDtoList) {
        this.sellerWithProductsDtoList = sellerWithProductsDtoList;
    }
}
