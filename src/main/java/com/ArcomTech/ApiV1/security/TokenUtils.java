package com.ArcomTech.ApiV1.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    //@Value("${token.secret}")
	private String tokenSecret;	
	
    private static String ACCESS_TOKEN_SECRET;

    //@Value("${token.secret}")
    public void setAccessTokenSecret(String tokenSecret){
    	TokenUtils.ACCESS_TOKEN_SECRET = tokenSecret;
    }

    //@Value("${token.validity-seconds}")
	private String tokenValiditySeconds;
	
    private static Long ACCESS_TOKEN_VALIDITY_SECONDS;
    
    //@Value("${token.validity-seconds}")
    public void setAccessTokenValiditySeconds(String tokenValiditySeconds){
    	TokenUtils.ACCESS_TOKEN_VALIDITY_SECONDS = Long.valueOf(tokenValiditySeconds);
    }


    public static String createToken( String mail){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("mail", mail);
        return Jwts.builder()
                .setSubject(mail)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String mail = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(mail, null, Collections.emptyList());

        }catch (JwtException e){
            return  null;
        }
    }

}
