/**
 * 
 */
package recruitSystem.action.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.management.ManagerService;
import recruitSystem.service.user.UserService;
import recruitSystem.view.User;

/**
 * @author 72412
 *
 */
@Controller
@RequestMapping("/managerPage/userListPage")
public class ManagementUserController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String userList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,@RequestParam(value = "tag", defaultValue = "all") String tag, Model model) {
		//PaginationSupport<User> users = userRepository.findUsers(pageNo,tag);
		//model.addAttribute("pages", users);
		return "manager/userList";
	}
	
	/*
	 * 查看用户的账号信息
	 */
	@RequestMapping(value = "/userAccountPage", method = RequestMethod.GET)
	public String userAccount(@RequestParam(value = "userId", defaultValue = "0") String userId, Model model) {
		User user = userService.findUser(userId);
		model.addAttribute("userAccount", user);
		return "manager/userAccount";
	}
	
	/*
	 * 修改用户的信誉分
	 */
	@RequestMapping(value = "/alterUserScorePage", method = RequestMethod.GET)
	public String alterUserScore() {
		return "";
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(value = "/deleteUserPage", method = RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "userId", defaultValue = "0") String userId) {
		// 设置用户的删除标志为0
		userService.deleteUser(userId);
		
		return "redirect:/managerPage/userListPage";

	}
	

	
	


}
