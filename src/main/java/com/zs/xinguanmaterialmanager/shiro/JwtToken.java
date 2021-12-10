//package com.zs.xinguanmaterialmanager.shiro;
//
//import org.apache.shiro.authc.AuthenticationToken;
//
///**
// * @author Zanson
// * @since 2021/12/9 21:31
// **/
//public class JwtToken implements AuthenticationToken {
//    private String token;
//
//    public JwtToken(String token) {
//        this.token = token;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return token;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return token;
//    }
//}