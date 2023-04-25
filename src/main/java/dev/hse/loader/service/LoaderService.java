package dev.hse.loader.service;

import dev.hse.loader.mapper.CryptocurrencyMapper;
import dev.hse.loader.pojo.CryptocurrencyFiltered;
import dev.hse.loader.pojo.entity.CryptocurrencyRecord;
import dev.hse.loader.repository.CryptocurrencyRepository;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j(topic = "[loader][cryptocurrency][processing]")
@Service
@RequiredArgsConstructor
public class LoaderService {

    private final CryptocurrencyRepository repository;
    private final CryptocurrencyMapper mapper;
    private final MeterRegistry registry;
    private final Map<String, CryptocurrencyCollectorService> getCollectorFromSymbol = new HashMap<>();

    public void process(CryptocurrencyFiltered cryptocurrencyFiltered) {
        log.info("Processing: {}", cryptocurrencyFiltered);
        CryptocurrencyRecord record = mapper.toRecord(cryptocurrencyFiltered);
        var savedEntity = repository.save(record);

        CryptocurrencyCollectorService collectorService = getCollectorFromRecord(record);
        collectorService.updatePrice(record.getPriceUSD().intValue());
        log.info("Saved new record: {}", savedEntity);
    }

    private CryptocurrencyCollectorService getCollectorFromRecord(CryptocurrencyRecord record) {
        CryptocurrencyCollectorService collectorService;
        String symbol = record.getSymbol();
        if (!getCollectorFromSymbol.containsKey(symbol)) {
            collectorService = new CryptocurrencyCollectorService(symbol, registry);
            getCollectorFromSymbol.put(symbol, collectorService);
        }
        return getCollectorFromSymbol.get(symbol);
    }
}
