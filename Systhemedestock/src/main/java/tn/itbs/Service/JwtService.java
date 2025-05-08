package tn.itbs.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import tn.itbs.Models.Utilisateur;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token, org.springframework.security.core.userdetails.UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
    
    public String generateToken(org.springframework.security.core.userdetails.UserDetails userDetails) {
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername()) // ou getEmail()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 heures
                .signWith(getSignInKey())
                .compact();
    }
    public String generateToken(Utilisateur user) {
        return generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getMotDePasse(),
                new ArrayList<>()
        ));
    }


}
