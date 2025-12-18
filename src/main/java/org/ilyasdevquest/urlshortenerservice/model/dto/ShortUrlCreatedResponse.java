package org.ilyasdevquest.urlshortenerservice.model.dto;

import lombok.Data;

@Data
public class ShortUrlCreatedResponse {
    private String originalUrl;
    private String code;
    private String shortUrl;
}
