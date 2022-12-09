package com.bijw.generator.common.utils;

import com.bijw.generator.entity.DemoUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2022-12-08 13:30
 */
public class JwtHelper {

    //token字符串有效时间
    private static long tokenExpiration = 24*60*60*1000;

    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public static String creatToken(DemoUser user){

        Date now = new Date();

        JwtBuilder builder= Jwts.builder()
                .setId(UUID.randomUUID().toString()) // 载荷-标准中注册的声明
                .setSubject("123") // 载荷-标准中注册的声明
                .setIssuedAt(now) // 载荷-标准中注册的声明，表示签发时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userAge", user.getAge()) // 载荷-公共的声明
                .claim("userName",user.getName())
                .signWith(key); // 签证

        String jwt = builder.compact();

        return jwt;
    }

    public static Claims getUserClaims(String token){
        Claims claims = null;
        if (StringUtils.isEmpty(token)){
            return null;
        }
        try {
            claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (JwtException ex) { // jwt 不合法或过期都会抛异常
            ex.printStackTrace();
        }
        return claims;
    }
}
