package com.bookstore.api.model.serializer;

import com.bookstore.api.model.Bill;
import com.bookstore.api.model.BillItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BillSerializer extends JsonSerializer<Bill> {

    @Override
    public void serialize(Bill value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        jgen.writeObjectField("total", value.getTotal());
        jgen.writeObjectField("client", value.getClient());
        jgen.writeObjectField("user", value.getUser());

        if (value.getBillItems() != null && value.getBillItems().size() > 0) {
            jgen.writeArrayFieldStart("billItems");
            for (BillItem billItem : value.getBillItems()) {
                jgen.writeStartObject();
                jgen.writeObjectField("id", billItem.getId());
                jgen.writeObjectField("name", billItem.getName());
                jgen.writeObjectField("price", billItem.getPrice());
                jgen.writeObjectField("count", billItem.getCount());

                jgen.writeObjectFieldStart("book");
                jgen.writeObjectField("id", billItem.getBook().getId());
                jgen.writeEndObject();

                jgen.writeEndObject();
            }

            jgen.writeEndArray();

        }

        jgen.writeEndObject();
    }
}
