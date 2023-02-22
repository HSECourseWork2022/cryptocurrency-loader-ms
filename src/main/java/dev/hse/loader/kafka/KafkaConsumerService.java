package dev.hse.loader.kafka;

import dev.hse.loader.pojo.CryptocurrencyFiltered;
import dev.hse.loader.service.LoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[loader][template][kafka-consumer]")
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final LoaderService loaderService;

    @KafkaListener(topicPattern = ".+\\.${loader.subtheme}\\.filters\\.outcome")
    public void consumeTopic(CryptocurrencyFiltered cryptocurrencyFiltered) {
        log.info("Got from kafka: {} ", cryptocurrencyFiltered);
        loaderService.process(cryptocurrencyFiltered);
    }
}
