package com;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Book {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String cover;

    @JacksonXmlProperty
    @JacksonXmlElementWrapper(localName = "authors")
    private List<Author> authors;

    @JacksonXmlProperty
    private String title;

    @JacksonXmlProperty
    private String genre;

    @JacksonXmlProperty(localName = "price")
    private Price price;

    @JacksonXmlProperty(localName = "publish_date")
    @JsonProperty("publish_date") @JsonDeserialize(using = MultiDateDeserializer.class)
    private LocalDate publishDate;

    @JacksonXmlProperty
    private String description;



}
