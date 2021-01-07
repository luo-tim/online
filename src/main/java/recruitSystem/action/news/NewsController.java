package recruitSystem.action.news;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.view.*;
import recruitSystem.service.news.*;
import recruitSystem.service.user.UserService;

/**
 * 
 * @author LJTTT
 *
 */
@Controller
@RequestMapping("/newsPage")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	/**
	 * 进入消息页面,默认显示第一条消息，没有消息则提示为空
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String news(@RequestParam(value = "index", defaultValue = "0")int index, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("1111");
		if (user == null) {
			return "redirect:/newsPage/notNewsPage";// 重定向到没有信息的页面
		} else {
			List<User> users = newsService.findSendUser(user.getId());
			System.out.println("sss");
			if (users == null) {// 如果没有消息
				return "redirect:/newsPage/notNewsPage";// 重定向到没有信息的页面
			}else {// 如果有消息
				System.out.println("222");
				User user2 = users.get(index);
				List<Information> informations = newsService.findInformations(user.getId(), user2.getId());// 获取信息列表
				model.addAttribute("users", users);// 发送者列表
				model.addAttribute("news", informations);// 显示的消息

				model.addAttribute("userName", user2.getUserName());
				return "news";
			}
		}
	}
	
	/**
	 * 提示没有消息
	 */
	@RequestMapping(value = "/notNewsPage", method = RequestMethod.GET)
	public String notNews() {
		return "notNews";
	}
	
}
