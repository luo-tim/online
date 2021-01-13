/**
 * 
 */
package recruitSystem.action.home;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import recruitSystem.util.MD5;
import recruitSystem.view.User;

/**
 * 系统的主页控制类
 * 
 * @author 72412
 *
 */
@Controller // 控制定义
@RequestMapping("/") // 相对web路径
public class HomeController {

//	@Autowired
//	private UserService userService;

	/**
	 * 欢迎页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET) // get请求
	public String welcomePage(Model model) {
		return "index";
	}

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String homePage(Model model) {
		// 加载首页时可以获取公司，动态生成热门公司
		Subject subject = SecurityUtils.getSubject();

		// 如果 isAuthenticated 为 false 证明不是登录过的，同时 isRememberd 为true 证明是没登陆直接通过记住我功能进来的
		System.out.println("subject.isAuthenticated()" + subject.isAuthenticated());
		System.out.println("subject.isRemembered()" + subject.isRemembered());
		if (subject.isAuthenticated() || subject.isRemembered()) {

			// 获取session看看是不是空的
			Session session = subject.getSession(true);

			// 随便拿session的一个属性来看session当前是否是空的，我用userId，你们的项目可以自行发挥
			if (session.getAttribute("user") == null) {

				// 如果是空的才初始化，否则每次都要初始化，项目得慢死
				// 这边根据前面的前提假设，拿到的是username
				User user = (User) subject.getPrincipal();
				UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
				try {
					subject.login(token);
				} catch (UnknownAccountException e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("登录失败" + e.getMessage());

				} catch (LockedAccountException e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("登录失败" + e.getMessage());

				} catch (AuthenticationException e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("登录失败" + e.getMessage());

				}
				// String password = subject.get
				// System.out.println(user.getAccount());
				// System.out.println("11111");
			}
			// System.out.println("222222");
		}

		// System.out.println("33333");
		return "home";
	}

	/**
	 * 搜索职业
	 * 
	 * @param query
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/homePage", method = RequestMethod.POST)
	public String searchJob(@RequestParam(value = "query", defaultValue = "") String query, RedirectAttributes attr) {
		// System.out.println(query);
		attr.addAttribute("type", "工作类型");
		attr.addAttribute("pro", "省份");
		attr.addAttribute("city", "城市");
		attr.addAttribute("query", query);
		return "redirect:/employmentPage";
	}

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	/**
	 * 登录请求
	 * 
	 * @param account
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String processLogin(@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "password", defaultValue = "") String password,@RequestParam(value="remember",defaultValue="0")Integer remember, HttpSession session, Model model) {
		System.out.println(remember);
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// 将用户名密码封装为UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(account, MD5.md5(password));
			if (remember==1) {
				token.setRememberMe(true);
			}
			// System.out.println(currentUser.isRemembered());
			try {
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("登录失败" + e.getMessage());
				model.addAttribute("loginError", "用户不存在，请重新登录");
				return "login";// 登录失败返回登录失败提醒页面
			} catch (LockedAccountException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("登录失败" + e.getMessage());
				model.addAttribute("loginError", "该账号已被封禁");
				return "login";// 登录失败返回登录失败提醒页面
			} catch (AuthenticationException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("登录失败" + e.getMessage());
				model.addAttribute("loginError", "登录失败");
				return "login";// 登录失败返回登录失败提醒页面
			}
		}
		//
//		//校验用户名，密码是否正确
//		if (user==null) {
//			model.addAttribute("loginError", "用户不存在，请重新登录");
//			return "login";// 登录失败返回登录失败提醒页面
//		}
//		//校验用户是否被封禁
//		if (!user.isEnable()) {
//			model.addAttribute("loginError", "该账号已被封禁");
//			return "login";// 登录失败返回登录失败提醒页面
//		}
		// 将用户信息保存到session
		//
		//
		// System.out.println(currentUser.getPrincipal().toString());
		if (currentUser.isAuthenticated()) {
//			User user=userService.selectUser(account, MD5.md5(password));
//			session.setAttribute("user", user);
			return "redirect:/homePage";// 返回首页
		} else {
			model.addAttribute("loginError", "登录失败");
			return "login";// 登录失败返回登录失败提醒页面
		}

	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 删除整个会话
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		//session.invalidate();
		
		return "redirect:/homePage";// 返回首页
	}

}
