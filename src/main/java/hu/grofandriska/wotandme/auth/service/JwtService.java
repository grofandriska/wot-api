package hu.grofandriska.wotandme.auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );
    }

    /**
     * token generálás
     * token validálás
     * username extract
     * expiration ellenőrzés
     * */


    /* ===================================================== */
    /* ================= TOKEN GENERATION ================== */
    /* ===================================================== */
    public String generateToken(UserDetails user){
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(expirationDate())
                .signWith(key)
                .compact();
    }

    private Date expirationDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

    /* ===================================================== */
    /* ================= TOKEN EXTRACTION =================== */
    /* ===================================================== */
   public String extractUsername(String token){
       return extractClaim(token, Claims::getSubject);
   }
   public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
       final Claims claims = extractAllClaims(token);
       return claimsResolver.apply(claims);
   }

   private Claims extractAllClaims(String token){
       return Jwts.parser()
               .verifyWith(key)
               .build()
               .parseSignedClaims(token)
               .getPayload();
   }

    /* ===================================================== */
    /* ================= TOKEN VALIDATION ================== */
    /* ===================================================== */

    public boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        Date expiration = extractClaim(token,Claims::getExpiration);
        return expiration.before(new Date());
    }
}
