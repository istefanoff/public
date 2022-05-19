package com;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Author {

    @JacksonXmlProperty(localName = "first_name")
    private String firstName;

    @JacksonXmlProperty(localName = "last_name")
    private String lastName;

}

