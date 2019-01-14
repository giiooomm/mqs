package com.system.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.Service.UserService;
import com.user.model.User;
 
 
public class UserRealm extends AuthorizingRealm {
    @Autowired
	private UserService userService;
	public static final String SESSION_USER_KEY = "gray";
 
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
	 */ 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}
 
	/**
	 * 认证回调函数，登录信息和用户验证信息验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		// 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从AdminController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        token.setRememberMe(true); 
        User user = new User();
        user.setUsercode(token.getUsername());
        user.setPassword(new String(token.getPassword()));
        User currentUser = userService.getByToken(user);
        if (null != currentUser) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(currentUser.getUsercode(), currentUser.getPassword(),
                    getName());
            this.setSession("currentUser", currentUser);
            return authcInfo;
        } else {
            return null;
        }
	}
 
    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }

}
