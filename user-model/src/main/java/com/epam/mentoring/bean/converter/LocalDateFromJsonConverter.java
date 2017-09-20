package com.epam.mentoring.bean.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateFromJsonConverter extends StdDeserializer<LocalDate> {

    public LocalDateFromJsonConverter() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
        return LocalDate.parse(jsonParser.readValueAs(String.class));
    }
}
