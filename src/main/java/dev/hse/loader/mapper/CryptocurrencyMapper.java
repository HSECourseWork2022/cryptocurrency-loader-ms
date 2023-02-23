package dev.hse.loader.mapper;

import dev.hse.loader.pojo.CryptocurrencyFiltered;
import dev.hse.loader.pojo.entity.CryptocurrencyRecord;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyMapper {

    public CryptocurrencyRecord toRecord(CryptocurrencyFiltered filtered) {
        return CryptocurrencyRecord.builder()
                .id(null)
                .symbol(filtered.getSymbol())
                .vendor(filtered.getVendor())
                .observedAt(filtered.getObservedAt())
                .maxSupply(filtered.getMaxSupply())
                .circulatingSupply(filtered.getCirculatingSupply())
                .totalSupply(filtered.getTotalSupply())
                .priceUSD(filtered.getPriceUSD())
                .volume24h(filtered.getVolume24h())
                .marketCap(filtered.getMarketCap())
                .build();
    }
}
