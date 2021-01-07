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

@Controller
@RequestMapping("/newsPage")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
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
			
			
//			if (row == 0) {// 如果没有消息
//				return "redirect:/newsPage/notNewsPage";// 重定向到没有信息的页面
//			} else {// 如果有消息
//				System.out.println("222");
////				List<User> users = newsRepository.findSendUser(user.getId());
////				List<User> users = newsService.findSendUser(user.getId());
//				// System.out.println(index);
//				User user2 = users.get(index);
////				List<Information> informations = newsRepository.findInformations(user.getId(), user2.getId());// 获取信息列表
//				List<Information> informations = newsService.findInformations(user.getId(), user2.getId());// 获取信息列表
//				model.addAttribute("users", users);// 发送者列表
//				model.addAttribute("news", informations);// 显示的消息
//
//				model.addAttribute("userName", user2.getUserName());
//				return "news";
//			}
		}
	}
	
	@RequestMapping(value = "/notNewsPage", method = RequestMethod.GET)
	public String notNews() {
		return "notNews";
	}
	
}
