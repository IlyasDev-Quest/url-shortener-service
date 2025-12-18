package org.ilyasdevquest.urlshortenerservice.controller;

import lombok.RequiredArgsConstructor;
import org.ilyasdevquest.urlshortenerservice.service.ShortUrlQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortUrlQueryController {
    private final ShortUrlQueryService shortUrlQueryService;

    @GetMapping("/{code}")
    public ResponseEntity<Void> rerouteToOriginalUrl(@PathVariable String code) {
        var shortUrlOpt = shortUrlQueryService.getByCode(code);
        if (shortUrlOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String originalUrl = shortUrlOpt.get().getOriginalUrl();

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", originalUrl)
                .build();
    }
}
