package org.ilyasdevquest.urlshortenerservice.service;

import lombok.RequiredArgsConstructor;
import org.ilyasdevquest.urlshortenerservice.model.entity.ShortUrl;
import org.ilyasdevquest.urlshortenerservice.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortUrlQueryService {
    private final ShortUrlRepository shortUrlRepository;

    public Optional<ShortUrl> getByCode(String code){
        return shortUrlRepository.findByCode(code);
    }
}
