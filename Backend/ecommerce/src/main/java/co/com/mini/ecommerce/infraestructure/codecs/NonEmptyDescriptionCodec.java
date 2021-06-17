package co.com.mini.ecommerce.infraestructure.codecs;

import co.com.mini.ecommerce.Application.commons.NonEmptyDescription;
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
public class NonEmptyDescriptionCodec {

    public static class DescriptionEncoder extends JsonSerializer<NonEmptyDescription>{


        @Override
        public void serialize(NonEmptyDescription nonEmptyDescription, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(nonEmptyDescription.getValue());
        }
    }
    public static class DescriptionDecoder extends  JsonDeserializer<NonEmptyDescription>{

        @Override
        public NonEmptyDescription deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final String getvalue=jsonParser.getValueAsString();
            return new NonEmptyDescription(getvalue);
        }
    }
}
