package azo.developer.urlshortener.repository;

import azo.developer.urlshortener.entity.UrlEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository urlRepository;

    private final static UrlEntity URL_ENTITY = UrlEntity.builder()
            .realUrl("https://www.youtube.com/watch?v=MrkPc_mFQWU")
            .shortUrl("https://azo/mfhJ89")
            .build();

    @BeforeEach
    void initDatabase() {
        urlRepository.save(URL_ENTITY);
    }

    @Test
    void findUrlEntityByShortUrl_should_return_entity() {
        UrlEntity urlEntity = urlRepository.findUrlEntityByShortUrl(URL_ENTITY.getShortUrl());

        assertThat(urlEntity.getRealUrl()).isEqualTo(URL_ENTITY.getRealUrl());
        assertThat(urlEntity.getShortUrl()).isEqualTo(URL_ENTITY.getShortUrl());
    }
}
