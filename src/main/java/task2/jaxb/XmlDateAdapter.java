package task2.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mordr on 13.04.2017.
 */
public class XmlDateAdapter extends XmlAdapter<String, Date> {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Date unmarshal(String v) throws Exception {
        return DATE_FORMAT.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return DATE_FORMAT.format(v);
    }
}
