package com.bookstore.api.model.serializer;

import com.bookstore.api.model.Client;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ClientSerializer extends JsonSerializer<Client> {

    @Override
    public void serialize(Client value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("name", value.getName());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        jgen.writeObjectField("phoneNumber", value.getPhoneNumber());

        jgen.writeEndObject();
    }
}
