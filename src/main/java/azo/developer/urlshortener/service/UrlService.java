package azo.developer.urlshortener.service;

import azo.developer.urlshortener.constants.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlService {

    private final IUrlShortenerService urlShortenerService;

    public String generateShortenUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        boolean isUrlValid = urlValidator.isValid(url);

        if (!isUrlValid) {
            log.info(Messages.SHORTEN_URL_FAILED);
            throw new IllegalArgumentException(Messages.SHORTEN_URL_FAILED);
        }

        return urlShortenerService.generateShortUrl();
    }
}
