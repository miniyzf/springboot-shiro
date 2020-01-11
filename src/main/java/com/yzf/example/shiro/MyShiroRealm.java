package com.yzf.example.shiro;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.SysUser;
import com.yzf.example.service.SysPermissionService;
import com.yzf.example.service.SysRoleService;
import com.yzf.example.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * MyShiroRealm
 *
 * @author Administrator
 * @date 2020/1/4
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 权限认证
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行;
     * 如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//        Session session = SecurityUtils.getSubject().getSession();
//        SysUser sysUser = (SysUser) session.getAttribute("USER_SESSION");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 身份认证 new SimpleAuthenticationInfo(sysUser,
        SysUser sysUser  = null;
        try {
            sysUser = (SysUser)principals.getPrimaryPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*// 身份认证 new SimpleAuthenticationInfo(username,
        String username = (String)principals.getPrimaryPrincipal();
        SysUser sysUser = sysUserService.findByUsername(username);*/

        if(sysUser != null){
            List<SysRole> roleList = sysRoleService.getAllRole(sysUser.getUid());
            for(SysRole role:roleList){
                authorizationInfo.addRole(role.getRole());
                List<SysPermission> permissionList = sysPermissionService.getAllPermission(role.getId());
                for(SysPermission p:permissionList){
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            }

            // 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
            //authorizationInfo.setRoles(roles);
            //authorizationInfo.setStringPermissions(stringPermissions);
        }
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        String userPwd = new String((char[])token.getCredentials());

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser sysUser = sysUserService.findByUsername(username);
        if(sysUser == null){
            throw new UnknownAccountException();
        }
        if(sysUser.getState() == 2){
            throw new LockedAccountException();
        }

        // 交给 AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配，如果觉得人家的不好可以自定义实现 myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        // TODO 如果使用 HashedCredentialsMatcher 这里认证方式就要改一下 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, "密码", ByteSource.Util.bytes("密码盐"), getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), ByteSource.Util.bytes(username + sysUser.getSalt()),getName());
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, sysUser.getPassword(), getName());

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", sysUser);
        return authenticationInfo;
    }

}
