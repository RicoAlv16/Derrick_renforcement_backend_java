package com.derrick.demo.getway.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    private final String SECRET_KEY = "RxHn6CSbelzKRSY6WSLsO8Dz6qdscTRe"; // Clé secrète statique
    private final SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();

        // Allow unauthenticated access to Auth-Service
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }

        // Validate the token
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            // Token is missing
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().add("Content-Type", "application/json");
            String response = "{\"error\": \"Missing Authorization token\"}";
            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse().bufferFactory().wrap(response.getBytes()))
            );
        }

        String token = headers.getFirst(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
        try {
            // Parse and validate the token
            Jwts.parserBuilder()
                    .setSigningKey(secretKeySpec)
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception e) {
            // Token is invalid
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().add("Content-Type", "application/json");
            String response = "{\"error\": \"Invalid Authorization token\"}";
            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse().bufferFactory().wrap(response.getBytes()))
            );
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1; // Higher priority
    }
}
