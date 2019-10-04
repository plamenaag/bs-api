package com.bookstore.api.model.serializer;

import com.bookstore.api.model.User;
import com.bookstore.api.model.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("username", value.getUsername());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        

        jgen.writeEndObject();
    }
}
