package azo.developer.urlshortener.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class UrlShortenServiceSimpleImplTest {

    @Autowired
    private UrlShortenServiceSimpleImpl urlShortenServiceSimple;

    @Test
    public void generateShortUrl_should_generate_shorten_url() {
        String shortenUrl = urlShortenServiceSimple.generateShortUrl();

        assertThat(shortenUrl, Matchers.matchesPattern("^([A-Za-z0-9]{6})$"));
    }
}
