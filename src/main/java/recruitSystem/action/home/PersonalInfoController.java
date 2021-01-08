/**
 * 
 */
package recruitSystem.action.home;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.job.JobService;
import recruitSystem.service.user.UserService;
import recruitSystem.view.Company;
import recruitSystem.view.Job;
import recruitSystem.view.User;

/**
 * @author 72412
 *个人中心页面控制
 */
@Controller
@RequestMapping("/personalPage")
public class PersonalInfoController {

	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	/**
	 * 进入个人中心页面，显示账户信息
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String accountInfo(Model model, HttpSession session) {
		model.addAttribute("message", "userInfo");
		return "person/personalAccount";
	}
	
	/*
	 * 修改个人信息
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String accountInfoSubmit(@RequestParam(value = "userName", defaultValue = "") String userName, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (!user.getUserName().equals(userName)) {
			userService.updateUserName(userName,user.getAccount());
			user.setUserName(userName);
			session.setAttribute("user", user);
		}

		return "redirect:/personalPage";
	}
	
	/**
	 * 人个人信息
	 */
	@RequestMapping(value = "/infoPage", method = RequestMethod.GET)
	public String workerInfo(Model model) {
		model.addAttribute("message", "basicInfo");
		return "person/personalAccount";
	}
	/**
	 * 个人信息修改
	 */
	@RequestMapping(value = "/infoPage", method = RequestMethod.POST)
	public String workerInfoSubmit(@RequestParam(value = "lastName", defaultValue = "") String lastName,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "birth", defaultValue = "2020-08-08") String birth,
			@RequestParam(value = "IDNumber", defaultValue = "") String IDNumber,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "sex", defaultValue = "") String sex, HttpSession session) throws ParseException {
		User user=(User) session.getAttribute("user");
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setDateOfBirth(birth);
		user.setIDNumber(IDNumber);
		user.setPhoneNumber(phone);
		user.setEmail(email);
		user.setSex(sex);
		userService.updateBasicInfo(user);
		session.setAttribute("user", user);
	
		return "redirect:/personalPage/infoPage";
	}
	

	/*
	 * 发布的工作
	 */
	@RequestMapping(value = "/releaseInfoPage", method = RequestMethod.GET)
	public String releaseInfo(@RequestParam(value = "tag", defaultValue = "3") int tag, Model model,
			HttpSession session) {
		model.addAttribute("message", "bossRelease");
		User user =(User) session.getAttribute("user");

		List<Job> jobs = jobService.findReleaseJob(user.getId(), tag);// 工作的标志0代表招聘中，1代表招聘结束，2代表删除，5代表审核中
		model.addAttribute("bossRelease", jobs);
		return "person/personalAccount";
	}
	
	/*
	 * 申请的工作
	 */
	@RequestMapping(value = "/requestInfoPage", method = RequestMethod.GET)
	public String requestInfo(@RequestParam(value = "tag", defaultValue = "0") int tag, Model model,
			HttpSession session) {
		model.addAttribute("message", "workerSignup");
		User user = (User) session.getAttribute("user");
		List<Job> jobs = jobService.findSignupJob(user.getId(), tag);// 其他代表全部，，1代表申请中，2代表成功，3代表拒绝
		model.addAttribute("workerSignup", jobs);

		return "person/personalAccount";
	}
	
	/*
	 * 打工人的浏览记录
	 */
	@RequestMapping(value = "/workHistoryInfoPage", method = RequestMethod.GET)
	public String workHistoryInfo(Model model, HttpSession session) {
		model.addAttribute("message", "workerHistory");
		User user = (User) session.getAttribute("user");
		List<Job> jobs = jobService.findHistoryJob(user.getId());
		model.addAttribute("workerHistory", jobs);
		return "person/personalAccount";
	}
	/**
	 * HR所属公司
	 */
	@RequestMapping(value = "/companyInfoPage", method = RequestMethod.GET)
	public String companyInfo(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		Company company =companyService.findCompanyByBossId(user.getId());
		model.addAttribute("message", "bossCompany");
		model.addAttribute("company", company);
		return "person/personalAccount";
	}

}
