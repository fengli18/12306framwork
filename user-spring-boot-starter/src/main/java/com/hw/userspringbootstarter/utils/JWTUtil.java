package com.hw.userspringbootstarter.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.hw.basespringbootstarter.constant.UserConstant;
import com.hw.userspringbootstarter.core.UserInfoDTO;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTUtil {
    private static final long EXPIRATION = 86400L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ISS = "index12306";
    public static final String SECRET = "SecretKey039245678901232039487623456783092349288901402967890140939827";

    /**
     * 生成jwt token
     * @param userInfoDTO 用户信息
     * @return token
     */
    public static String generateAccessToken(UserInfoDTO userInfoDTO) {
        Map<String, Object> customUserMap = new HashMap<>();
        customUserMap.put(UserConstant.USER_ID_KEY, userInfoDTO.getUserId());
        customUserMap.put(UserConstant.USER_NAME_KEY, userInfoDTO.getUsername());
        customUserMap.put(UserConstant.REAL_NAME_KEY, userInfoDTO.getRealName());
        String jwtToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuedAt(new Date()) // jwt发布时间
                .setIssuer(ISS) // jwt发布者
                .setSubject(JSON.toJSONString(customUserMap)) // jwt主题
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000)) // 1天后过期
                .compact();
        return TOKEN_PREFIX + jwtToken;
    }

    /**
     * 解析jwtToken
     * @param jwtToken
     * @return
     */
    public static UserInfoDTO parseJwtToken(String jwtToken) {
        if (StringUtils.hasText(jwtToken)) {
            // 获取真实token
            String actualToken = jwtToken.replace(TOKEN_PREFIX, "");
            try {
                // 解析jws
                Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(actualToken).getBody();
                // 获取过期时间
                Date expiration = body.getExpiration();
                if (expiration.after(new Date())) {
                    // 如果未过期 则获取用户信息的json信息
                    String subject = body.getSubject();
                    // 反序列化为UserInfoDTO
                    return JSON.parseObject(subject, UserInfoDTO.class);
                }
            } catch (ExpiredJwtException e) {
                log.error("jwt已过期");
            } catch (Exception ex) {
                log.error("解析失败，请看错误信息", ex);
            }
        }
        return null;
    }
}
