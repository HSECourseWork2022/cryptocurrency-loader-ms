package dev.hse.loader.service;

import dev.hse.loader.mapper.CryptocurrencyMapper;
import dev.hse.loader.pojo.CryptocurrencyFiltered;
import dev.hse.loader.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[loader][cryptocurrency][processing]")
@Service
@RequiredArgsConstructor
public class LoaderService {

    private final CryptocurrencyRepository repository;
    private final CryptocurrencyMapper mapper;

    public void process(CryptocurrencyFiltered cryptocurrencyFiltered) {
        log.info("Processing: {}", cryptocurrencyFiltered);
        var savedEntity = repository.save(mapper.toRecord(cryptocurrencyFiltered));
        log.info("Saved new record: {}", savedEntity);
    }
}
