package SAX_Parser;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
    class Book {

@JacksonXmlProperty
        private String id;

    @JacksonXmlProperty
        private String author;

    @JacksonXmlProperty
        private String title;

    @JacksonXmlProperty
        private String genre;
    @JacksonXmlProperty
        private BigDecimal price;

    @JacksonXmlProperty
        private LocalDate publishDate;

    @JacksonXmlProperty
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


