package org.ilyasdevquest.urlshortenerservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrlCreateRequest {
    @NotBlank(message = "Original URL cannot be empty")
    private String originalUrl;
}
