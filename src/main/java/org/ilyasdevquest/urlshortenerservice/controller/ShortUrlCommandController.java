package org.ilyasdevquest.urlshortenerservice.controller;

import lombok.RequiredArgsConstructor;
import org.ilyasdevquest.urlshortenerservice.model.dto.ShortUrlCreateRequest;
import org.ilyasdevquest.urlshortenerservice.model.dto.ShortUrlCreatedResponse;
import org.ilyasdevquest.urlshortenerservice.service.ShortUrlCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/short-urls")
public class ShortUrlCommandController {
    private final ShortUrlCommandService shortUrlCommandService;

    @PostMapping
    public ResponseEntity<ShortUrlCreatedResponse> createShortUrl(@RequestBody ShortUrlCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrlCommandService.createShortUrl(request));
    }
}
