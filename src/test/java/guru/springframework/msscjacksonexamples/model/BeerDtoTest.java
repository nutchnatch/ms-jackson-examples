package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
         String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"7ebe8a66-234c-4da7-8d2a-675fcde3cb50\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123212342345,\"price\":12.99,\"createdDate\":\"2020-10-18T21:39:04.856863+01:00\",\"lastUpdatedDate\":\"2020-10-18T21:39:04.857623+01:00\"}";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto.toString());
    }
}