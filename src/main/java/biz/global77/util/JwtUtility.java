package biz.global77.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final long JWT_TOKEN_EXPIRATION = 6000;
	
	private String secretKey = "secret";
	
	private Claims getAllClaimsFromJwtToken(String jwtToken) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
	}
	
	public <T> T getClaimsFromToken(String jwtToken, Function<Claims, T> resolver) {
		final Claims claims = getAllClaimsFromJwtToken(jwtToken);
		return resolver.apply(claims);
	}
	
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }
	
	public Date getExpirationDateFromToken(String jwtToken) {
		return getClaimsFromToken(jwtToken, Claims::getExpiration);
	}
	
	public Boolean isTokenExpired(String jwtToken) {
		final Date expirationDate = getExpirationDateFromToken(jwtToken);
		return expirationDate.before(new Date());
	}
	
	public String generateJwtToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}
	
    public String jwtToken(String jwtToken) {
        Map<String, Object> claims = new HashMap<>();
        return generateJwtToken(claims, jwtToken);
    }
    
    public Boolean validateToken(String jwtToken, UserDetails userDetails) {
        final String username = getUsernameFromToken(jwtToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
    }

}
