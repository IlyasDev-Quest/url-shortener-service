package org.ilyasdevquest.urlshortenerservice.repository;

import org.ilyasdevquest.urlshortenerservice.model.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
    Optional<ShortUrl> findByOriginalUrl(String originalUrl);
    Optional<ShortUrl> findByCode(String code);
    boolean existsByCode(String code);
}
