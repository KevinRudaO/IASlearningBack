package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
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
public class IdentificationNumberCodec {

    public static class IdentificationNumberEncoder extends JsonSerializer<IdentificationNumber>{


        @Override
        public void serialize(IdentificationNumber identificationNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(identificationNumber.getValue());
        }
    }
    public static class IdentificationNumberDecoder extends JsonDeserializer<IdentificationNumber>{

        @Override
        public IdentificationNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int ValueAsInt = jsonParser.getValueAsInt();
            return new IdentificationNumber(ValueAsInt);
        }
    }
}