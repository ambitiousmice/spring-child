package com.mice.web;

import com.mice.domain.UserBean;
import com.mice.service.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     授权(验证权限时调用)
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        UserBean userBean = (UserBean)principal.getPrimaryPrincipal();//获取用户
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //authorizationInfo.setRoles(new HashSet(roleService.getRoles(userBean.getId())));
        List<String> perms = userService.getAllPerms(userBean.getId());
        Set<String> permsSet = new HashSet();
        for (String perm : perms){
            if (StringUtils.isEmpty(perm)){
                continue;
            }else {
                permsSet.addAll(Arrays.asList(perm.split(",")));
            }
        }
        authorizationInfo.setStringPermissions(permsSet);
        return authorizationInfo;
    }

    /**
     * 登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            String userName = (String)authenticationToken.getPrincipal();
            String password =  new String((char[]) authenticationToken.getCredentials());
        UserBean userBean  = userService.getByUserName(userName);
            if(userBean==null){
                throw new UnknownAccountException("账号或密码不存在");
            }
            if(!userBean.getPassword().equals(password)){
                throw new IncorrectCredentialsException("账号或密码不正确");
            }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userBean, password, getName());
        return info;
    }
}
