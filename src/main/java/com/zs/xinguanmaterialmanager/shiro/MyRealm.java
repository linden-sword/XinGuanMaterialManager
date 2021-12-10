package com.zs.xinguanmaterialmanager.shiro;

import com.zs.xinguanmaterialmanager.entity.TbUser;
import com.zs.xinguanmaterialmanager.mapper.TbUserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Zanson
 * @since 2021/12/7 10:35
 **/
@Component
public class MyRealm extends AuthorizingRealm {

    @Resource
    private TbUserMapper tbUserMapper;

    public String getName(){
        return "myrealm";
    }

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取当前用户的用户名
        String username = (String) authenticationToken.getPrincipal();
        //去数据库中查询该用户
        TbUser user = tbUserMapper.findByUsername(username);
//        System.out.println("================"+user.getUsername()+user.getPassword());

        if (user == null) {
            return null;
        }

        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }
}
