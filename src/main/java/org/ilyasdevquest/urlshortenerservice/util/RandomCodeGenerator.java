package org.ilyasdevquest.urlshortenerservice.util;

import java.security.SecureRandom;

public class RandomCodeGenerator {

    // Base62 characters: 0-9, a-z, A-Z
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be positive");

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(BASE62.length());
            sb.append(BASE62.charAt(index));
        }
        return sb.toString();
    }
}
