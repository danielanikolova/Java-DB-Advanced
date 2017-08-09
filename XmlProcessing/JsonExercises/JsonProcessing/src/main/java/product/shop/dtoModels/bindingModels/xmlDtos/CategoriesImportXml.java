package product.shop.dtoModels.bindingModels.xmlDtos;

import product.shop.dtoModels.bindingModels.Add.CategoryAddDto;
import product.shop.entities.Category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesImportXml {

    @XmlElement(name = "category")
    private List<CategoryAddDto> categoryAddDtos;

    public CategoriesImportXml() {
    }

    public List<CategoryAddDto> getCategoryAddDtos() {
        return categoryAddDtos;
    }

    public void setCategoryAddDtos(List<CategoryAddDto> categoryAddDtos) {
        this.categoryAddDtos = categoryAddDtos;
    }
}
