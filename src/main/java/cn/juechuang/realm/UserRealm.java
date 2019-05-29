package cn.juechuang.realm;

import cn.juechuang.model.User;
import cn.juechuang.service.UserService;
import cn.juechuang.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //给授权对象设置权限

        //设置角色
/*        Set<String> roles = new HashSet<String>();
        //模拟从数据库的角色表中获取角色添加信息
        roles.add("admin");
        roles.add("superadmin");
        //设置权限
        Set<String> permissions=new HashSet<String>();
        permissions.add("user:create");
        permissions.add("user:delete");
        permissions.add("user:update");*/
        //添加到授权信息中
/*
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
*/
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        authorizationInfo.setRoles(userService.getUserRoleSet(user.getId()));
        //添加到授权信息中
        authorizationInfo.setStringPermissions(userService.getUserPermissionSet(user.getId()));
        return authorizationInfo;
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String userpassword = new String((char[]) authenticationToken.getCredentials());
        User user = userService.login(username, userpassword);
/*        System.out.println(userpassword+"ZZZZZZ");
        String juechuang = MD5Util.md5("123456", "juechuang");
        System.out.println(juechuang+"aaaaaaaa");*/
/*        if(!username.equals(user.getUsername())){
            throw new UnknownAccountException("用户不存在");
        }
        if (!userpassword.equals(user.getPassword())){
            throw new IncorrectCredentialsException("密码错误");
        }*/

        return new SimpleAuthenticationInfo(user, userpassword, getName());
    }
}
