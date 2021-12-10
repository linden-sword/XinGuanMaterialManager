package com.zs.xinguanmaterialmanager.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zanson
 * @since 2021/12/7 10:35
 **/
@Configuration
public class ShiroConfig {

    /**
     * 核心过滤器ShiroFilter
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

//        //设置权限
//        Map<String, String> filterMap=new HashMap<>();
//        filterMap.put("/XinGuan/user","authc");   //认证通过
//        filterMap.put("/student/select","anon"); //所有人
////        filterMap.put("/student/update","perms[student:*]");
//        filterMap.put("/student/update","perms[student:update]");
//        filterMap.put("/student/delete","roles[admin]");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }


    /**
     * security  manager
     * DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager getSecurityManager(MyRealm realm,MySessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm，支持多个reaml
        securityManager.setRealm(realm);

        //设置会话管理方式
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }


    /**
     * 会话管理：DefaultWebSessionManager
     */
    @Bean
    public MySessionManager getDefaultWebSessionManager(){
        MySessionManager   sessionManager=new MySessionManager();
//        sessionManager.setSessionDAO(sessionDao);
        return sessionManager;
    }

    /**
     * realm
     */
    /*@Bean
    public MyRealm getRealm() {
        return new MyRealm();
    }*/
}