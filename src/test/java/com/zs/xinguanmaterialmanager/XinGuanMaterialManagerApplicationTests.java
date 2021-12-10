package com.zs.xinguanmaterialmanager;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@SpringBootTest
class XinGuanMaterialManagerApplicationTests {

    @Test
    void contextLoads() {
    }

//    /**
//     * 生成token
//     */
//    @Test
//    public   void  JWTCreatTest(){
//        String token = JWT.create()
//                //设置header
//                .withHeader(new HashMap<>())
//                //设置payload
//                .withClaim("login", true)
//                .withClaim("username", "zhangsan")
//                .withExpiresAt(new Date(new Date().getTime() + 7 * 24 * 3600 * 1000))
//                .withIssuer("hs")
//                .withJWTId(UUID.randomUUID().toString())
//                //设置签名算法和密钥
//                .sign(Algorithm.HMAC256("abcdefg"));
//
//        System.out.println(token);
//    }


//    /**
//     * 解析token
//     */
//    @Test
//    public  void   test2(){
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("abcdefg")).build();
//
//        String  token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJocyIsImxvZ2luIjp0cnVlLCJleHAiOjE2Mzg5NDk5OTMsImp0aSI6IjllN2IzMzRkLTc1YTItNDgxZi04YmY1LTE2Y2Y0NzEyMTFmNCIsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.bz4cbX1l9Pf9c2FXT1P2NThwcuzxsTgIn13dZ-et_yg";
//
//        //验签
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);
//
//        //通过，即可获取数据
////        获取头部
//        String header=decodedJWT.getHeader();
////        获取载荷
//        String  payload=decodedJWT.getPayload();
////        获取签名
//        String  signature=decodedJWT.getSignature();
//        System.out.println(header);
//        System.out.println(payload);
//        System.out.println(signature);
//
////        解析数据
//        Claim login = decodedJWT.getClaim("login");
//        System.out.println(login.asBoolean());
//        Claim username = decodedJWT.getClaim("username");
//        System.out.println(username.asString());
//        String id = decodedJWT.getId();
//        System.out.println(id);
//
//
//    }

}
