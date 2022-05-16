package azo.developer.urlshortener.controller;

import azo.developer.urlshortener.constants.Messages;
import azo.developer.urlshortener.entity.UrlEntity;
import azo.developer.urlshortener.model.ShortenUrlRequest;
import azo.developer.urlshortener.model.ShortenUrlResponse;
import azo.developer.urlshortener.repository.UrlRepository;
import azo.developer.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;
    private final UrlRepository urlRepository;

    /**
     * returns the shorten version of the passed url
     */
    @PostMapping("/url/shorten")
    public ResponseEntity<ShortenUrlResponse> shortUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        boolean isShortenUrlAlreadyInUse = true;
        String shortenUrl = "";

        while(isShortenUrlAlreadyInUse) {
            shortenUrl = urlService.generateShortenUrl(shortenUrlRequest.getUrl());
            isShortenUrlAlreadyInUse = urlRepository.findUrlEntityByShortUrl(shortenUrl) != null;
        }

        urlRepository.save(UrlEntity.builder()
                .realUrl(shortenUrlRequest.getUrl())
                .shortUrl(shortenUrl)
                .build());

        ShortenUrlResponse response = ShortenUrlResponse.builder()
                .shortenUrl(shortenUrl)
                .message(Messages.SHORTEN_URL_SUCCESSFUL)
                .build();

        return ResponseEntity.ok(response);
    }

    /**
     * routes the shorten url with the identifier to the real url
     *
     * @param identifier
     */
    @GetMapping("/{identifier}")
    public void routeUrl(@PathVariable String identifier, HttpServletResponse httpServletResponse) {
        UrlEntity urlEntity = urlRepository.findUrlEntityByShortUrl(identifier);

        if(urlEntity != null) {
            httpServletResponse.setHeader("Location", urlEntity.getRealUrl());
            httpServletResponse.setStatus(302);
        }
    }
}
