package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        JAXBContext jaxbContext;

        File file = new File("src/main/resources/catalog.xml");

        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Catalog catalog = (Catalog) unmarshaller.unmarshal(file);

            for (Book book : catalog.getBookList()) {
                System.out.println(book);
            }

        }
        catch (JAXBException e){
            e.printStackTrace();
        }

    }
}
