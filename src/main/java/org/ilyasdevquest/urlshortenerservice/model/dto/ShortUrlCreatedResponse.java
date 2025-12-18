package org.ilyasdevquest.urlshortenerservice.model.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ShortUrlCreatedResponse {
    private String originalUrl;
    private String code;
    private String shortUrl;
}
