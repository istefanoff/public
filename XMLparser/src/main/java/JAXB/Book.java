package JAXB;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.LocalDate;

import java.math.BigDecimal;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Book {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlElement
    //@XmlAttribute
    private String author;

    //    @XmlAttribute
    @XmlElement
    private String title;

    //    @XmlAttribute
    @XmlElement
    private String genre;

    //    @XmlAttribute
    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "publish_date")
    @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.yyyy_MM_dd.class)
    private LocalDate publishDate;

    //    @XmlAttribute
    @XmlElement
    private String description;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", description='" + description + '\'' +
                '}';
    }
}