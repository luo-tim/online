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

import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.user.UserService;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.User;

/**
 * @author 72412
 *用户管理
 */
@Controller
@RequestMapping("/managerPage/userListPage")
public class ManagementUserController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	/**
	 * 管理员获取用户列表
	 * @param pageNo
	 * @param tag
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String userList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,@RequestParam(value = "tag", defaultValue = "all") String tag, Model model) {
		PaginationSupport<User> users = userService.findUsers(pageNo,tag);
		model.addAttribute("pages", users);
		return "manager/userList";
	}
	
	/**
	 * 查看用户的账号信息
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userAccountPage", method = RequestMethod.GET)
	public String userAccount(@RequestParam(value = "userId", defaultValue = "0") String userId, Model model) {
		User user = userService.findUser(userId);
		if (user.getIdentityId()==1) {
			String companyName=companyService.findCompanyName(user.getId());
			model.addAttribute("companyName", companyName);
		}
		
		model.addAttribute("userAccount", user);
		return "manager/userAccount";
	}
	
	/**
	 * 修改用户的信誉分
	 * @return
	 */
	@RequestMapping(value = "/alterUserScorePage", method = RequestMethod.GET)
	public String alterUserScore() {
		return "";
	}
	
	/**
	 * 删除用户
	 * @param userId
	 * @param tag
	 * @return
	 */
	@RequestMapping(value = "/deleteUserPage", method = RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "userId", defaultValue = "0") String userId,@RequestParam(value = "tag", defaultValue = "all") String tag) {
		// 设置用户的删除标志为0
		userService.deleteUser(userId);
		
		return "redirect:/managerPage/userListPage?tag="+tag;

	}
	

	
	


}
