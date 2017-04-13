package task2.jaxb;

import task2.pojo.Human;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Mordr on 13.04.2017.
 */
@XmlRootElement(name = "humans")
public class XmlHumansWrapper {
    private List<Human> humans;

    public XmlHumansWrapper() {

    }

    public List<Human> getHumans() {
        return humans;
    }

    @XmlElement(name="human")
    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    public Object xmlUnMarshall(String fileName) {
        XmlUnMarshaller xmlUnMarshaller = new XmlUnMarshaller();
        Object object = xmlUnMarshaller.unMarshallObject(this.getClass(), fileName);
        return object;
    }
}
