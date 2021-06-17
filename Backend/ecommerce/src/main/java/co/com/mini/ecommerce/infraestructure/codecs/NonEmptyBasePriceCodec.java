package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.commons.NonEmptyBasePrice;
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
public class NonEmptyBasePriceCodec {

    public static class BasePriceEncoder extends JsonSerializer<NonEmptyBasePrice>{


        @Override
        public void serialize(NonEmptyBasePrice nonEmptyBasePrice, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(nonEmptyBasePrice.getValue());
        }
    }
    public static class BasePriceDecoder extends JsonDeserializer<NonEmptyBasePrice>{

        @Override
        public NonEmptyBasePrice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
           final int getBaseprice= jsonParser.getValueAsInt();
            return new NonEmptyBasePrice(getBaseprice);
        }
    }
}
