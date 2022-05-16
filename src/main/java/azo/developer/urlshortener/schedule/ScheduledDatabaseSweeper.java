package azo.developer.urlshortener.schedule;

import azo.developer.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledDatabaseSweeper {

    private final UrlRepository urlRepository;

    /**
     * sweeps the database at fixed delay to avoid overhead
     */
    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedDelay = 5)
    public void sweepDatabase() {
        log.info(String.format("Database swept: %s ", LocalDateTime.now()));
        urlRepository.deleteAll();
    }
}
