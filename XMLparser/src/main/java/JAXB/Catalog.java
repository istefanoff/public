package JAXB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Catalog {

    @XmlElement
    public List<Book> book = new ArrayList<>();

    public Catalog() {
    }

    public List<Book> getBookList() {
        return book;
    }

    public void setBookList(List<Book> bookList) {
        this.book = bookList;
    }
}
