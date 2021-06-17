package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.commons.NonEmptyInvQuantity;
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
public class NonEmptyInventoryQuantity {

    public static class NonEmptyQuantityEncoder extends JsonSerializer<NonEmptyInvQuantity>{


        @Override
        public void serialize(NonEmptyInvQuantity nonEmptyInvQuantity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(nonEmptyInvQuantity.getValue());
        }
    }
    public static class NonEmptyQuantityDecoder extends JsonDeserializer<NonEmptyInvQuantity>{

        @Override
        public NonEmptyInvQuantity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int getInvQuantity= jsonParser.getValueAsInt();
            return new NonEmptyInvQuantity(getInvQuantity);
        }
    }
}
