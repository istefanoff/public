package SAX_Parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        CatalogHandler catalogHandler = new CatalogHandler();

        saxParser.parse("src/main/resources/catalog.xml", catalogHandler);

        List<Book> result = catalogHandler.getCatalog();

        for (Book book : result) {
            System.out.println(book);
        }
    }
}
