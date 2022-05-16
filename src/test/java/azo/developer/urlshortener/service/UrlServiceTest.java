package azo.developer.urlshortener.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UrlServiceTest {

    @Mock
    private IUrlShortenerService urlShortenerService;

    @InjectMocks
    private UrlService urlService;

    @Test
    public void generateShortenUrl_should_invoke_generateShortUrl() {
        String testurl = "https://test.com";

        Mockito.when(urlShortenerService.generateShortUrl()).thenReturn(testurl);
        urlService.generateShortenUrl(testurl);

        Mockito.verify(urlShortenerService).generateShortUrl();
    }
}
