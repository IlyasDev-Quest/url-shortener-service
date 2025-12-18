package org.ilyasdevquest.urlshortenerservice.model.dto;

import jakarta.validation.constraints.NotBlank;

public class ShortUrlAccessRequest {
    @NotBlank(message = "Short URL cannot be empty")
    private String shortUrl;
}
