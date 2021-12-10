package com.zs.xinguanmaterialmanager.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zs.xinguanmaterialmanager.entity.TbUser;
import org.apache.shiro.SecurityUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author Zanson
 * @since 9:23 2021/12/7
 **/
public class JWTUtil {
    private static final long expire = 3600 * 1000;
    private static final String security = "!@#$%H*&^SxJ";

    /**
     * 生成token
     *
     * @param iss, sub, jti, claims
     * @return java.lang.String
     * @author Zanson
     * @since 9:29 2021/12/7
     **/
    public static String toToken(String iss, String sub, String jti, Map<String, String> claims) {
        JWTCreator.Builder builder = JWT.create();

//        Algorithm algorithm = Algorithm.

        //设置头部
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");
        builder.withHeader(headers);
        //设置载荷
        //默认字段
        builder.withIssuer(iss);   //发行者
        builder.withSubject(sub);  //主题
        builder.withJWTId(jti);    //token唯一表示（使用sessionId）
        builder.withIssuedAt(new Date());  //发行时间
        builder.withExpiresAt(new Date(new Date().getTime() + expire));  //过期时间
        //自定义字段
        if (claims != null) {
            claims.forEach(builder::withClaim);
        }
        //签名，生成token
        return builder.sign(Algorithm.HMAC256(security));
    }


    /**
     * 验签
     *
     * @param token
     * @return boolean
     * @author Zanson
     * @since 9:28 2021/12/7
     **/
    public static boolean parseToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(security)).build();
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 解析数据
     *
     * @param token
     * @return com.auth0.jwt.interfaces.DecodedJWT
     * @author Zanson
     * @since 9:27 2021/12/7
     **/
    public static DecodedJWT parseData(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(security)).build();
        return jwtVerifier.verify(token);
    }

}