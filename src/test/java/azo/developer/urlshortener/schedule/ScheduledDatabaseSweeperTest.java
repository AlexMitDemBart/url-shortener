package azo.developer.urlshortener.schedule;

import azo.developer.urlshortener.entity.UrlEntity;
import azo.developer.urlshortener.repository.UrlRepository;
import com.google.common.collect.Iterables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScheduledDatabaseSweeperTest {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private ScheduledDatabaseSweeper scheduledDatabaseSweeper;

    private static final UrlEntity URL_ENTITY = UrlEntity.builder()
            .shortUrl("https://azo/Mhj83A")
            .realUrl("https://www.youtube.com/watch?v=QF9ySLM-Kg8")
            .build();

    @BeforeEach
    void initDatabase() {
        urlRepository.save(URL_ENTITY);
    }

    @Test
    void sweepDatabase_should_sweep_database() {
        scheduledDatabaseSweeper.sweepDatabase();

        Iterable<UrlEntity> entities = urlRepository.findAll();

        assertThat(Iterables.size(entities)).isZero();
    }
}
