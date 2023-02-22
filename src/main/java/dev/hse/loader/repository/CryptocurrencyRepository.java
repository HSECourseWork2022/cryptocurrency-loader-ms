package dev.hse.loader.repository;

import dev.hse.loader.pojo.entity.CryptocurrencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyRecord, Long> {
}
