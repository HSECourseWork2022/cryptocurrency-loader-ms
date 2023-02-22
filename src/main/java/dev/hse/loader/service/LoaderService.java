package dev.hse.loader.service;

import dev.hse.loader.pojo.entity.CryptocurrencyRecord;
import dev.hse.loader.pojo.CryptocurrencyFiltered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[loader][template][processing]")
@Service
@RequiredArgsConstructor
public class LoaderService {

    public void process(CryptocurrencyFiltered cryptocurrencyFiltered) {
        log.info("Processing: {}", cryptocurrencyFiltered);
        CryptocurrencyRecord entry = new CryptocurrencyRecord();
        log.info("Processed: {}", entry);
    }
}
