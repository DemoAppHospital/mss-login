package pro.angelogomez.mss_login.infraestructure.jwt;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    public static final String SUPER_SECRET_KEY = "K4yN7wL9gR2mC8fP3tV6bZ1xJ8sU4qE7dW0aH5iL2oT9vM6yQ3rF8kX1c4nG3L0G0m3zB1tCh";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 days
    public static Key getSignedKey(String secretKey) {
        byte [] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}


