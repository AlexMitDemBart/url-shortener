package azo.developer.urlshortener.repository;

import azo.developer.urlshortener.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<UrlEntity, Long> {

    UrlEntity findUrlEntityByShortUrl(String shortUrl);
}
