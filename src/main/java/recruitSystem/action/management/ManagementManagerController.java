/**
 * 
 */
package recruitSystem.action.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.news.NewsService;
import recruitSystem.service.user.UserService;
import recruitSystem.view.Information;
import recruitSystem.view.User;

/**
 * @author 72412
 *管理员的管理员控制
 */
@Controller
@RequestMapping("/managerPage/managerListPage")
public class ManagementManagerController {

	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	/*
	 * 进入管理者列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String ManagementManager(@RequestParam(value="pageNo",defaultValue="1")int pageNo,Model model) {
		// 管理员列表
//		PaginationSupport<Manager> managers = managerRepository.findManagers(pageNo);
//		model.addAttribute("pages", managers);
		return "manager/managerList";
	}
	
	/**
	 * 查看管理者的账户详情信息
	 */
	@RequestMapping(value = "/managerAccountInfoPage", method = RequestMethod.GET)
	public String managerAccountInfo(@RequestParam(value = "userId", defaultValue = "0") String userId, Model model) {
		User user = userService.findUser(userId);
		model.addAttribute("userAccount", user);
		return "userAccount";
	}
	
	/**
	 * 删除管理员
	 */
	@RequestMapping(value = "/deleteManagerPage", method = RequestMethod.GET)
	public String deleteManager(@RequestParam(value = "userId", defaultValue = "0") String  userId) {
		 userService.deleteUser(userId);
		
			return "redirect:/managerPage/managerListPage";
	

	}
	
	
	/*
	 * 升级为超级管理员
	 */
	@RequestMapping(value = "/upManagerPage", method = RequestMethod.GET)
	public String upManager(@RequestParam(value = "userId", defaultValue = "0") String userId,HttpSession session) {
			userService.updateManager(userId);
		
			User user = (User) session.getAttribute("user");
			
			Information information = new Information();// 发送消息
			information.setSendId(user.getId());
			information.setReceiveId(userId);
			information.setContext("你已经被升级为超级管理员");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			information.setPostTime(dateFormat.format(new Date()));
			newsService.sendMessage(information);
			return "redirect:/managerPage/managerListPage";
		}
	
	/*
	 * 进入增加管理员界面
	 */
	@RequestMapping(value = "/addManagerPage", method = RequestMethod.GET)
	public String addManager() {
		return "basicInfo";
	}

	@RequestMapping(value = "/addManagerPage", method = RequestMethod.POST)
	public String managerSubmit(@RequestParam(value = "lastName", defaultValue = "") String lastName,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "birth", defaultValue = "") String birth,
			@RequestParam(value = "IDNumber", defaultValue = "") String IDNumber,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "sex", defaultValue = "") String sex, HttpSession session) throws ParseException {
	
		User user = new User();
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setDateOfBirth(birth);
		user.setIDNumber(IDNumber);
		user.setPhoneNumber(phone);
		user.setEmail(email);
		user.setSex(sex);
		user.setIdentityId(2);
		session.setAttribute("newManager", user);
		return "redirect:/registerPage/accountInfoPage";// 返回账号密码注册页面
	}

	}



