package JAXB;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    public static final class yyyyMMdd extends LocalDateAdapter {
        public yyyyMMdd() {
            super("yyyyMMdd");
        }
    }

    public static final class yyyy_MM_dd extends LocalDateAdapter {
        public yyyy_MM_dd() {
            super("yyyy-MM-dd");
        }
    }

    private DateTimeFormatter formatter;

    public LocalDateAdapter(String pattern) {
        formatter = DateTimeFormat.forPattern(pattern);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return formatter.print(date);
    }

    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return formatter.parseLocalDate(date);
    }

}