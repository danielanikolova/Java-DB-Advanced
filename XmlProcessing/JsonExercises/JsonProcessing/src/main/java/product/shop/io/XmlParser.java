package product.shop.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class XmlParser {

    private JAXBContext jaxbContext;


    public XmlParser(){
    }

    @SuppressWarnings("unchecked")
    public <T>T getObject(Class<T> clazz, String path) throws JAXBException, IOException {

        this.jaxbContext = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        T object = null;

        try(
                InputStream inputStream = clazz.getResourceAsStream(path);

        ){
           object =(T)unmarshaller.unmarshal(inputStream);
            return object;
        }

    }

    public <T> void writeObject(T obj, String path) throws JAXBException, IOException {

        this.jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = this.jaxbContext
                .createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        try(
                OutputStream outputStream = new FileOutputStream(path)
                ){
           marshaller.marshal(obj, outputStream);
        }
    }

}
