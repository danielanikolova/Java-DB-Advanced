package product.shop.dtoModels.bindingModels.xmlDtos;

import product.shop.dtoModels.bindingModels.Add.UserAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportXmlDto {

    @XmlElement(name = "user")
    private List<UserAddDto> userAddDtos;

    public UsersImportXmlDto() {
    }

    public List<UserAddDto> getUserAddDtos() {
        return userAddDtos;
    }

    public void setUserAddDtos(List<UserAddDto> userAddDtos) {
        this.userAddDtos = userAddDtos;
    }
}
