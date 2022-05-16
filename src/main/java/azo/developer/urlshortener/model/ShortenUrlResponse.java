package azo.developer.urlshortener.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortenUrlResponse {

    private String shortenUrl;
    private String message;
}
