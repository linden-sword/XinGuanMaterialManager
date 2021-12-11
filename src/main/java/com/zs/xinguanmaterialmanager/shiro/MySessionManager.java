package com.zs.xinguanmaterialmanager.shiro;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zs.xinguanmaterialmanager.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 会话管理器
 *
 * @author Zanson
 * @since 2021/12/7 9:35
 **/
@Slf4j
public class MySessionManager extends DefaultWebSessionManager {


    /**
     * 从请求中获取sessionId
     * 默认从cookie中获取会话编号sessionID,
     * 重写方法改为从Header中获取。
     *
     * @param request, response
     * @return java.io.Serializable
     * @author Zanson
     * @since 9:49 2021/12/7
     **/
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        System.out.println("///=== Token: "+token);
        if (token == null || token.trim().equals("") || !JWTUtil.parseToken(token)) {
            //按默认规则从cookie取sessionId(就是没有ID创建一个ID)
            return super.getSessionId(request, response);
        } else {
            DecodedJWT decodedJWT = JWTUtil.parseData(token);
            String id = decodedJWT.getId();

            //从JWT中解析到username
            String username = decodedJWT.getClaim("username").asString();
            System.out.println("///=== LoginUserName(MySessionManagerGetSessionID): "+username);

            //如果请求头中有 Authorization 则其值为sessionId
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "url");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        }
    }


    /**
     * 响应
     * 默认响应: 将会话编号保存在cookie中。
     * 改为: 将会话编号保存在响应头的token中。
     *
     * @param session, context
     * @author Zanson
     * @since 9:50 2021/12/7
     **/
    @Override
    protected void onStart(Session session, SessionContext context) {
        System.out.println("///=== session start ...........");
        super.onStart(session, context);
        if (!WebUtils.isHttp(context)) {
            log.debug("SessionContext argument is not HTTP compatible or does not have an HTTP request/response pair. No session ID cookie will be set.");
        } else {
            HttpServletRequest request = WebUtils.getHttpRequest(context);
            HttpServletResponse response = WebUtils.getHttpResponse(context);

            //将会话编号保存在resp的header的token中
            Serializable id = session.getId();

            //获取当前登录的用户
            String username = (String) request.getAttribute("username");
            System.out.println("///=== LoginUserName(MySessionManagerOnStart): "+username);

            Map<String,String> map = new HashMap<>();
            map.put("username",username);

            String token = JWTUtil.toToken("zs", "java", id.toString(), map);
            response.addHeader("token", token);
            //允许token跨域
            response.addHeader("Access-Control-Expose-Headers","token");

            request.removeAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_IS_NEW, Boolean.TRUE);
        }

    }

}
