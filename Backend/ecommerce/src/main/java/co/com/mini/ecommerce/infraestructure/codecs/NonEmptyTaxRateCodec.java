package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.commons.NonEmptyTaxRate;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
@JsonComponent
public class NonEmptyTaxRateCodec {

    public static class TaxRateEncoder extends JsonSerializer<NonEmptyTaxRate>{


        @Override
        public void serialize(NonEmptyTaxRate nonEmptyTaxRate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(nonEmptyTaxRate.getValue());
        }
    }
    public static class TaxRateDecoder extends JsonDeserializer<NonEmptyTaxRate>{

        @Override
        public NonEmptyTaxRate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int getTaxRate = jsonParser.getValueAsInt();
            return new NonEmptyTaxRate(getTaxRate);
        }
    }
}
