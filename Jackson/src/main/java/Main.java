import com.Book;
import com.Catalog;
import com.Currency;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());

        // read file and put contents into the string
        String readContent = new String(Files.readAllBytes(Paths.get("src/main/resources/ms_books.xml")));

        // deserialize from the XML into a Catalog object
        Catalog catalog = xmlMapper.readValue(readContent, Catalog.class);


        //read bnb table
        Document doc = Jsoup.connect("https://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm").get();

        Elements contentBox = doc.getElementsByClass("table_box");
        Elements rows = contentBox.select("tr");

        Map<String, Currency> exchange = mapCurrencies(rows);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (Book book : catalog.getBooks()) {
            String currency = book.getPrice().getCurrency().toUpperCase();

            //if book has price
            if (book.getPrice().getValue() != null) {
                BigDecimal value = book.getPrice().getValue().multiply(exchange.get(currency).getValue());
                value = value.setScale(2, RoundingMode.HALF_EVEN);

                if (book.getPublishDate() != null) {
                    System.out.println("Title: " + book.getTitle() + " Price: " + value + "лв" + " Publisher date: " + book.getPublishDate().format(formatter));
                } else {
                    System.out.println("Title: " + book.getTitle() + " Price: " + value + "лв" + " Publisher date: N/A");
                }

            } else { // on demand
                String value = book.getPrice().getPriceOnDemand();

                if (book.getPublishDate() != null) {
                    System.out.println("Title: " + book.getTitle() + " Price: " + value + " Publisher date: " + book.getPublishDate().format(formatter));
                } else {
                    System.out.println("Title: " + book.getTitle() + " Price: " + value + " Publisher date: N/A");
                }

            }
        }

    }

    private static Map<String, Currency> mapCurrencies(Elements rows) {
        Map<String, Currency> exchange = new HashMap<>();

        for (int i = 1; i < rows.size()-1; i++) {
            Currency currentCurrency = new Currency();
            Element element = rows.get(i);

            currentCurrency.setCurrency(element.child(1).text());

            //if table cells are not empty
            if (!element.child(2).text().equals("") && !element.child(3).text().equals("")) {

                BigDecimal quantity = BigDecimal.valueOf(Long.parseLong(element.child(2).text()));
                BigDecimal value = new BigDecimal(element.child(3).text());

                value = value.divide(quantity, RoundingMode.valueOf(5));
                currentCurrency.setValue(value);
            }


            exchange.put(currentCurrency.getCurrency(), currentCurrency);


        }
        return exchange;
    }
}
