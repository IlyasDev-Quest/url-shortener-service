package org.ilyasdevquest.urlshortenerservice.repository;

import org.ilyasdevquest.urlshortenerservice.model.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
    Optional<ShortUrl> findByCode(String urlCode);
    Optional<ShortUrl> findByOriginalUrl(String urlCode);
    boolean existsByOriginalUrl(String originalUrl);
    boolean existsByCode(String code);
}
