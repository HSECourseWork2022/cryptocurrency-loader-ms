package dev.hse.loader.service;

import dev.hse.loader.pojo.entity.CryptocurrencyRecord;
import io.micrometer.core.instrument.MeterRegistry;

import java.util.concurrent.atomic.AtomicInteger;

public class CryptocurrencyCollectorService {
    private final AtomicInteger price;

    public CryptocurrencyCollectorService(String symbol, MeterRegistry registry) {
        this.price = new AtomicInteger();
        registry.gauge(symbol, price);
    }

    void updatePrice(int value) {
        price.set(value);
    }

}
