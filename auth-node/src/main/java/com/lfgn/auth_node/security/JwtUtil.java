package com.lfgn.auth_node.security;

import com.lfgn.auth_node.model.Student;
import com.lfgn.auth_node.model.Faculty;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final String secret_key = "mysecretkey";
    private final long accessTokenValidity = TimeUnit.MINUTES.toMillis(60); // 1 hour
    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil() {
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(Object user) {
        Claims claims = Jwts.claims();
        Date now = new Date();
        Date expiry = new Date(now.getTime() + accessTokenValidity);

        if (user instanceof Student) {
            Student student = (Student) user;
            claims.setSubject(student.getUsername());
            claims.put("firstName", student.getFirstName());
            claims.put("lastName", student.getLastName());
            claims.put("role", "STUDENT");
        } else if (user instanceof Faculty) {
            Faculty faculty = (Faculty) user;
            claims.setSubject(faculty.getUsername());
            claims.put("firstName", faculty.getFirstName());
            claims.put("lastName", faculty.getLastName());
            claims.put("role", "FACULTY");
        } else {
            throw new IllegalArgumentException("Unsupported user type: " + user.getClass());
        }

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    public String getRole(Claims claims) {
        return (String) claims.get("role");
    }
}
