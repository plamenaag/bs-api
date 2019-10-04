package com.bookstore.api.model.serializer;

import com.bookstore.api.model.BillItem;
import com.bookstore.api.model.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BillItemSerializer extends JsonSerializer<BillItem> {

    @Override
    public void serialize(BillItem value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        jgen.writeObjectField("name", value.getName());
        jgen.writeObjectField("fromDate", value.getFromDate());
        jgen.writeObjectField("thruDate", value.getThruDate());
        jgen.writeObjectField("price", value.getPrice());
        jgen.writeObjectField("count", value.getCount());
        jgen.writeObjectField("book", value.getBook());
        
        if (value.getBill() != null) {
            jgen.writeObjectFieldStart("bill");
            jgen.writeObjectField("id", value.getBill().getId());
            jgen.writeEndObject(); 
        }


        jgen.writeEndObject();
    }
}
