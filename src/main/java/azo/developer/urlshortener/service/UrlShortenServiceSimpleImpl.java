package azo.developer.urlshortener.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlShortenServiceSimpleImpl implements IUrlShortenerService {

    private final static String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     *  simple algorithm to generate a 6 digit identifier for an shorten url
     *  possibility of 6^62 combinations
     */
    public String generateShortUrl() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 6; i++) {
            Random rand = new Random();
            int index = rand.nextInt(CHARS.length());
            sb.append(CHARS.charAt(index));
        }

        return sb.toString();
    }
}
