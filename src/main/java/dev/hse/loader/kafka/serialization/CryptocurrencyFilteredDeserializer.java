package dev.hse.loader.kafka.serialization;

import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.loader.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.loader.pojo.CryptocurrencyFiltered;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j(topic = "[loader][cryptocurrency][kafka-deserializer]")
public class CryptocurrencyFilteredDeserializer implements Deserializer<CryptocurrencyFiltered> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public CryptocurrencyFiltered deserialize(String s, byte[] bytes) {
        try {
            return mapper.readValue(bytes, CryptocurrencyFiltered.class);
        } catch (IOException e) {
            log.error("Error occurred while deserializing ", e);
            return null;
        }
    }
}
