/**
 * 
 */
package recruitSystem.action.home;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.user.UserService;
import recruitSystem.util.MD5;
import recruitSystem.view.User;

/**
 * @author 72412
 *注册控制类
 */
@Controller
@RequestMapping("/registerPage")
public class RegisterController {

	@Autowired 
	private UserService userService;
	@Autowired
	private CompanyService  companyService;
	
	
	/**
	 * 进入注册页面，选择身份
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String selectIdentity(HttpSession session) {
		session.invalidate();
		return "register/selectIdentity";
	}

	
	
	/**
	 *  工人 填写个人基础信息，
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/workerBasicInfo", method = RequestMethod.GET)
	public String workerBasicInfo(HttpSession session) {
		// 添加session
		User user=new User();
		user.setIdentityId(0);
		session.setAttribute("newUser", user);
		return "register/basicInfo";
	}

	
	/**
	 * 填写个人基础信息，老板的jsp页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/bossBasicInfo", method = RequestMethod.GET)
	public String bossBasicInfo(HttpSession session) {
		// 添加session
		User user=new User();
		user.setIdentityId(1);
		session.setAttribute("newUser", user);
		return "register/basicInfo";
	}


	/**
	 * 提交个人信息，目前写的是老板的提交
	 * @param lastName
	 * @param firstName
	 * @param birth
	 * @param IDNumber
	 * @param phone
	 * @param email
	 * @param company
	 * @param sex
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/bossBasicInfo", method = RequestMethod.POST)
	public String bossBasicInfoSubmit(@RequestParam(value = "lastName", defaultValue = "") String lastName,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "birth", defaultValue = "") String birth,
			@RequestParam(value = "IDNumber", defaultValue = "") String IDNumber,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "company", defaultValue = "") String company,
			@RequestParam(value = "sex", defaultValue = "") String sex, HttpSession session) throws ParseException {
		String companyId=companyService.findCompany(company);
		if (companyId!=null) {
			User user=(User) session.getAttribute("newUser");
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setDateOfBirth(birth);
			user.setIDNumber(IDNumber);
			user.setPhoneNumber(phone);
			user.setSex(sex);
			session.setAttribute("newUser", user);
			session.setAttribute("companyId", companyId);
			return "redirect:/registerPage/accountInfoPage";// 返回账号密码注册页面
		}else {
			return "redirect:/registerPage/notFoundCompanyPage";// 返回到提醒页面
		}
				

	}
	
	
	/**
	 * 公司未注册提示
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notFoundCompanyPage", method = RequestMethod.GET)
	public String notFoundCompany(HttpSession session, Model model) {

		model.addAttribute("error", "该公司不存在");
		return "error/error";
	}
	
	
	/**
	 * 提交个人信息，目前写的是打工人的提交
	 * @param lastName
	 * @param firstName
	 * @param birth
	 * @param IDNumber
	 * @param phone
	 * @param email
	 * @param sex
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/workerBasicInfo", method = RequestMethod.POST)
	public String workerBasicInfoSubmit(@RequestParam(value = "lastName", defaultValue = "") String lastName,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "birth", defaultValue = "") String birth,
			@RequestParam(value = "IDNumber", defaultValue = "") String IDNumber,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "sex", defaultValue = "") String sex, HttpSession session) throws ParseException {
		User user=(User) session.getAttribute("newUser");
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(birth);
		user.setIDNumber(IDNumber);
		user.setPhoneNumber(phone);
		user.setSex(sex);
		session.setAttribute("newUser", user);
		return "redirect:/registerPage/accountInfoPage";// 返回账号密码注册页面
	}

	/**
	 * 填写用户信息
	 * @return
	 */
	@RequestMapping(value = "/accountInfoPage", method = RequestMethod.GET)
	public String accountInfo() {
		return "register/accountInfo";
	}
	
	/**
	 * 提交用户信息
	 * @param userName
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/accountInfoPage", method = RequestMethod.POST)
	public String accountInfoSubmit(@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {
		int num=userService.countUser(account);
		if (num==0) {//用户不存在，则创建用户
			userService.insert(session,userName,account,password);
			return "redirect:/loginPage";// 成功返回注册页面
			
		}else {
			session.removeAttribute("newUser");
			return "redirect:/registerPage/UserExistPage";// 返回错误页面
		}
	}
	/**
	 * 用户存在页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserExistPage", method = RequestMethod.GET)
	public String UserExist(Model model) {
		model.addAttribute("error", "用户账号已经存在");
		return "error/error";
	}
}
