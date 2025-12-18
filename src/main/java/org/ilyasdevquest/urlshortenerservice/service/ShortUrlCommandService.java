package org.ilyasdevquest.urlshortenerservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ilyasdevquest.urlshortenerservice.helper.ShortUrlCodeGenerator;
import org.ilyasdevquest.urlshortenerservice.model.dto.ShortUrlCreateRequest;
import org.ilyasdevquest.urlshortenerservice.model.dto.ShortUrlCreatedResponse;
import org.ilyasdevquest.urlshortenerservice.model.entity.ShortUrl;
import org.ilyasdevquest.urlshortenerservice.repository.ShortUrlRepository;
import org.ilyasdevquest.urlshortenerservice.config.ShortUrlProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortUrlCommandService {
    private final ShortUrlRepository shortUrlRepository;
    private final ShortUrlProperties shortUrlProperties;
    private final ShortUrlCodeGenerator codeGenerator;

    @Transactional
    public ShortUrlCreatedResponse createShortUrl(ShortUrlCreateRequest request) {
        return shortUrlRepository.findByOriginalUrl(request.getOriginalUrl())
                .map(this::toResponse)
                .orElseGet(() -> {
                    String code = codeGenerator.generateUniqueCode();
                    ShortUrl entity = new ShortUrl(request.getOriginalUrl(), code);
                    shortUrlRepository.save(entity);
                    return toResponse(entity);
                });
    }

    private ShortUrlCreatedResponse toResponse(ShortUrl entity) {
        return ShortUrlCreatedResponse.builder()
                .originalUrl(entity.getOriginalUrl())
                .code(entity.getCode())
                .shortUrl(shortUrlProperties.baseUrl() + "/" + entity.getCode())
                .build();
    }
}