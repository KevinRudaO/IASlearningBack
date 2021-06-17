package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.commons.NonEmptyName;
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
public class NonEmptyNameCodec {
    public static class NameEncoder extends JsonSerializer<NonEmptyName>{


        @Override
        public void serialize(NonEmptyName nonEmptyName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(nonEmptyName.getValue());
        }
    }
    public static class NameDecoder extends JsonDeserializer<NonEmptyName>{

        @Override
        public NonEmptyName deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
             final String getNameAsString=jsonParser.getValueAsString();
            return new NonEmptyName(getNameAsString);
        }
    }
}
