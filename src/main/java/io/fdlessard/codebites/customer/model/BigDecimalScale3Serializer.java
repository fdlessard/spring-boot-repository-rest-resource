package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalScale3Serializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(
            BigDecimal value,
            JsonGenerator generator,
            SerializerProvider provider
    ) throws IOException {
        generator.writeNumber(value.setScale(3, RoundingMode.HALF_DOWN));
    }
}
