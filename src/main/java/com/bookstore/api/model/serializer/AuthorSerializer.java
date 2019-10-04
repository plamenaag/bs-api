package com.bookstore.api.model.serializer;

import com.bookstore.api.model.Author;
import com.bookstore.api.model.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AuthorSerializer extends JsonSerializer<Author> {

    @Override
    public void serialize(Author value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        jgen.writeObjectField("name", value.getName());
        jgen.writeObjectField("egn", value.getEgn());

        if (value.getBooks() != null && value.getBooks().size() > 0) {
            jgen.writeArrayFieldStart("books");
            for (Book book : value.getBooks()) {
                jgen.writeStartObject();
                jgen.writeObjectField("id", book.getId());
                jgen.writeObjectField("name", book.getName());
                jgen.writeEndObject();
            }

            jgen.writeEndArray();

        }

        jgen.writeEndObject();
    }
}
