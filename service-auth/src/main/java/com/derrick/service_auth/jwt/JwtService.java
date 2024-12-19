package com.derrick.service_auth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Clé secrète statique pour signer les tokens
    private final String SECRET_KEY = "RxHn6CSbelzKRSY6WSLsO8Dz6qdscTRe";
    private final SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

    // Génération du token
    // Stp Louis j'ai juste mis ici un username comme credential pour générer le token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expire dans 10 heures
                .signWith(secretKeySpec, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraction du username depuis le token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKeySpec)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Vérification si le token est expiré
    public boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKeySpec)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    // Vérification si le token est valide
    public boolean isTokenValid(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
