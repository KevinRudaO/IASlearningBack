package co.com.mini.ecommerce.infraestructureOrder.codecs;

import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;
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
public class OrderIdentificationJsonCodec {

    public static class OrderIdentificationSerializer extends JsonSerializer<OrderIdentificationNumber>{


        @Override
        public void serialize(OrderIdentificationNumber orderIdentificationNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(orderIdentificationNumber.getValue());
        }
    }
    public static class OrderIdentificationDeserializer extends JsonDeserializer<OrderIdentificationNumber>{

        @Override
        public OrderIdentificationNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final int valueAsInt = jsonParser.getValueAsInt();
            return new OrderIdentificationNumber(valueAsInt);
        }
    }

}
