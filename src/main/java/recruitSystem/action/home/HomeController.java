/**
 * 
 */
package recruitSystem.action.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import recruitSystem.service.user.UserService;

/**
 * 系统的主页控制类
 * 
 * @author 72412
 *
 */
@Controller // 控制定义
@RequestMapping("/") // 相对web路径
public class HomeController {

	@Autowired
	private UserService userService;
	/*
	 * 欢迎页面
	 */
	@RequestMapping(method = RequestMethod.GET) // get请求
	public String welcomePage(Model model) {
		return "index";
	}

	/*
	 * 首页
	 */
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String homePage() {
		// 加载首页时可以获取公司，动态生成热门公司
		return "home";
	}

	/*
	 * 搜索职业
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

	/*
	 * 登录页面
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	/*
	 * 登录请求
	 */
//	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
//	public String processLogin(@RequestParam(value = "account", defaultValue = "") String account,
//			@RequestParam(value = "password", defaultValue = "") String password, HttpSession session, Model model) {
//		int row=userRepository.finUser(account, password);
//		
//		if (row != 0) {
//			User user = userRepository.findUser(account, password);// 查找用户
//			String identity = user.getIdentity();
//			if (identity.equals("manager")) {
//
//				Manager manager = managerRepository.findManager(user.getIdentityId());
//
//				// 向session添加属性
//				session.setAttribute("user", user);
//				session.setAttribute("manager", manager);
//				session.setAttribute("identity", "manager");
//
//			} else if (identity.equals("boss")) {
//				Boss boss = bossRepository.findBoss(user.getIdentityId());
//
//				// 向session添加属性
//				session.setAttribute("user", user);
//				session.setAttribute("boss", boss);
//				session.setAttribute("identity", "boss");
//			} else if (identity.equals("worker")) {
//				// System.out.println(user.getIdentityId());
//				Worker worker = workerRepository.findWorker(user.getIdentityId());
//
//				// 向session添加属性
//				session.setAttribute("user", user);
//				session.setAttribute("worker", worker);
//				session.setAttribute("identity", "worker");
//			} else {
//				model.addAttribute("loginError", "登录失败，请重新登录");
//				return "login";// 登录失败返回登录失败提醒页面
//			}
//
//			return "redirect:/homePage";// 登录成功返回首页
//		} else {
//			model.addAttribute("loginError", "用户不存在，请重新登录");
//			return "login";// 登录失败返回登录失败提醒页面
//		}
//
//	}

	/*
	 * 退出登录
	 */
	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 删除整个会话
		session.invalidate();
		return "redirect:/homePage";// 返回首页
	}

}
