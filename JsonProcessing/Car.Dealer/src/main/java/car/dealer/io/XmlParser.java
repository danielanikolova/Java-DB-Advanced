package car.dealer.io;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlParser {

    private JAXBContext jaxbContext;

    public XmlParser() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance();
    }

    public <T>T getObject(Class<T> clazz, String path) throws JAXBException, IOException {
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        T object = null;

        try(
                InputStream inputStream = this.getClass().getResourceAsStream(path)
        ){
           object =(T)unmarshaller.unmarshal(inputStream);
        }

        return object;
    }

    public <T> void writeObject(T obj, String path) throws JAXBException, IOException {

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
