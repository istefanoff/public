package SAX_Parser;

import org.joda.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CatalogHandler extends DefaultHandler {
    private static final String CATALOG = "catalog";
    private static final String BOOK = "book";
    private static final String ID = "id";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String GENRE = "genre";
    private static final String PRICE = "price";
    private static final String PUBLISH_DATE = "publish_date";
    private static final String DESCRIPTION = "description";


    List<Book> bookList = new ArrayList<>();

    private Stack elementStack = new Stack();

    private Stack objectStack = new Stack();

    public void startDocument(){}

    public void endDocument(){}

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.elementStack.push(qName);

        //If this is start of 'user' element then prepare a new User instance and push it in object stack
        if ("book".equals(qName)) {

            Book book = new Book();

            //Set all required attributes in any XML element here itself
            if ( attributes != null && attributes.getLength() == 1)
            {
                book.setId(attributes.getValue(0));
            }
            this.objectStack.push(book);
        }
    }

    public void endElement(String uri, String localName, String qName) {

        this.elementStack.pop();

        //User instance has been constructed so pop it from object stack and push in userList
        if ("book".equals(qName)) {
            Book book1 = (Book) this.objectStack.pop();
            this.bookList.add(book1);
        }
    }


    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0) {
            return; // ignore white space
        }

        //handle the value based on to which element it belongs
        if ("author".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setAuthor(value);
        } else if ("title".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setTitle(value);
        } else if ("genre".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setGenre(value);
        } else if ("price".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setPrice(BigDecimal.valueOf(Double.parseDouble(value)));
        }
        else if ("publish_date".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setPublishDate(LocalDate.parse(value));
        }
        else if ("description".equals(currentElement())) {
            Book book = (Book) this.objectStack.peek();
            book.setDescription(value);
        }
    }

    /**
     * Utility method for getting the current element in processing
     */
    private String currentElement() {
        return (String) this.elementStack.peek();
    }

    //Accessor for userList object
    public List<Book> getCatalog() {
        return this.bookList;
    }
}