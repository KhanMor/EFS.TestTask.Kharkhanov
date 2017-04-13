package task2.jaxb;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Mordr on 13.04.2017.
 */
public class XmlUnMarshaller {
    private final static Logger LOGGER = Logger.getLogger(XmlUnMarshaller.class);

    public Object unMarshallObject(Class clazz, String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object object = jaxbUnmarshaller.unmarshal(file);
            return object;
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
