/**
 * 
 */
package recruitSystem.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import recruitSystem.service.user.UserService;
import recruitSystem.view.User;

/**
 * @author 72412
 *登录认证
 */
public class ShiroRealm extends AuthenticatingRealm {

	@Autowired
	private UserService userService;
	
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken userToken=(UsernamePasswordToken) token;
		User user=userService.selectUser(userToken.getUsername(),String.valueOf(userToken.getPassword()));
//		System.out.println("账号"+userToken.getPrincipal());
//		System.out.println("密码"+String.valueOf(userToken.getPassword()));
		//校验用户名，密码是否正确
		if (user==null) {
			throw new UnknownAccountException("用户不存在");
		}
		
		//校验用户是否被封禁
		if (!user.isEnable()) {
			throw new LockedAccountException("用户被封禁");
		}
		Subject currentUser = SecurityUtils.getSubject();
		  //获取session看看是不是空的
    	Session session = currentUser.getSession(true);
    	session.setAttribute("user", user);
		return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
	}


}
