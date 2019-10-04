package com.bookstore.api.model.serializer;

import com.bookstore.api.model.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BookSerializer extends JsonSerializer<Book> {

    @Override
    public void serialize(Book value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        jgen.writeObjectField("name", value.getName());
        jgen.writeObjectField("price", value.getPrice());
      

        //i sega interestnoto za da ne se vzeme celiq avtor s vsichkite mu knigi 
        if (value.getAuthor() != null) {
            jgen.writeObjectFieldStart("author");// toq red kazva zapochni mi nov obekt vutre v obekta s tozi kluch
            jgen.writeObjectField("id", value.getAuthor().getId());
            jgen.writeObjectField("name", value.getAuthor().getName());
            jgen.writeEndObject(); // kato prikluchish s vutreshniq obekt go zatvarqsh s }

        } else {
            jgen.writeObjectField("author", null);
        }

        jgen.writeEndObject();
    }
}
