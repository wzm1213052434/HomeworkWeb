package com.xaut.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.xaut.entity.User;
import com.xaut.service.UserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
    private UserService userService;
	
	/**
	 * 授权操作
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String)principals.getPrimaryPrincipal();
		
		//将user写进session中
		User user = userService.findUserByUsername(username);
		Subject currentUser = SecurityUtils.getSubject();
	    currentUser.getSession().setAttribute("user", user);
		
		//从数据库或者缓存中读取数据
        Set<String> roles = findRolesByUsername(username);
        Set<String> permissions = findPermissionsByUsername(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
	}
	
	/**
	 * 认证操作
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        
		// 1.从主体传过来的认证信息中，获得用户名
		String username = (String) token.getPrincipal();
		// 2.通过用户名到数据库中获取凭证
		User user = userService.findUserByUsername(username);
        
        if(user == null){
        	throw new UnknownAccountException();//没找到帐号
        }
        if(user.getPassword() == null) {
        	throw new IncorrectCredentialsException(); //密码错误
        }
        if(Boolean.TRUE.equals(user.isLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),getName());
        //加盐
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        return simpleAuthenticationInfo;
	}
	
	/**
	 * 根据username获取其role
	 */
    private Set<String> findRolesByUsername(String username) {
        List<String> list = userService.findRolesByUsername(username);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }
    
    /**
	 * 根据username获取其permission
	 */
    private Set<String> findPermissionsByUsername(String username) {
    	List<String> list = userService.findPermissionsByUsername(username);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }
    
	/**
	 * 获取realm名称
	 */
	@Override
    public String getName() {
        return "UserRealm";
    }
}
