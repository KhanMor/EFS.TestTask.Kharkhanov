package task2;

import task2.jaxb.XmlHumansWrapper;
import task2.pojo.Human;

import java.util.List;

/**
 * Created by Mordr on 12.04.2017.
 */
public class Task2Main {
    private final static String FILE_NAME = "src/main/resources/humans.xml";

    public static void main(String[] args) {
        XmlHumansWrapper xmlHumansWrapper = new XmlHumansWrapper();
        xmlHumansWrapper = (XmlHumansWrapper) xmlHumansWrapper.xmlUnMarshall(FILE_NAME);
        List<Human> humans = xmlHumansWrapper.getHumans();
        for (Human human : humans) {
            System.out.println(human);
        }
    }
}
