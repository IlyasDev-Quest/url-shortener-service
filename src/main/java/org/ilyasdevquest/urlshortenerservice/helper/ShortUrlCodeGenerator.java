package org.ilyasdevquest.urlshortenerservice.helper;

import lombok.RequiredArgsConstructor;
import org.ilyasdevquest.urlshortenerservice.repository.ShortUrlRepository;
import org.ilyasdevquest.urlshortenerservice.util.RandomCodeGenerator;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortUrlCodeGenerator {

    private static final int CODE_LENGTH = 7;
    private final ShortUrlRepository repository;

    public String generateUniqueCode() {
        while (true) {
            String code = RandomCodeGenerator.generate(CODE_LENGTH);
            try {
                if (!repository.existsByCode(code)) {
                    return code;
                }
            } catch (DataIntegrityViolationException e) {
                // retry
            }
        }
    }
}
