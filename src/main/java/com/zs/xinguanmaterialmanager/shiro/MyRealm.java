package com.zs.xinguanmaterialmanager.shiro;

import com.zs.xinguanmaterialmanager.entity.TbUser;
import com.zs.xinguanmaterialmanager.mapper.TbUserMapper;
import com.zs.xinguanmaterialmanager.service.TbUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zanson
 * @since 2021/12/7 10:35
 **/
@Component
public class MyRealm extends AuthorizingRealm {

    @Resource
    private TbUserMapper tbUserMapper;
    @Resource
    private TbUserService tbUserService;


    public String getName() {
        return "myrealm";
    }

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("///=== doGetAuthorizationInfo username: " + username);

        //根据用户名查询该用户的所有角色和权限
        List<String> roleList = tbUserService.findRoleNameByUsername(username);
        System.out.println("///=== doGetAuthorizationInfo roleList: "+roleList);
        List<String> permissionList = tbUserService.findPermissionNameByUsername(username);
        System.out.println("///=== doGetAuthorizationInfo permissionList: "+permissionList);

        //返回当前用户的所有角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(permissionList);

        return info;
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

        if (user == null) {
            return null;
        }

        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }
}
