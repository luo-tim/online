/**
 * 
 */
package recruitSystem.action.password;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.activateInfo.ActivateInfoService;
import recruitSystem.service.email.EmailService;
import recruitSystem.service.user.UserService;
import recruitSystem.util.MD5;
import recruitSystem.view.User;

/**
 * @author 72412
 *密码控制
 */
@Controller
@RequestMapping("/passwordPage")
public class PasswordControl {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ActivateInfoService activateInfoService;
	
	/**
	 * 进入修改页面
	 * @return
	 */
	@RequestMapping(value="alterPasswordPage", method = RequestMethod.GET)
	public String alterPassword() {
		return "password/alterPw";
	}
	/**
	 * 提交修改的密码
	 * @param account
	 * @param oldPassword
	 * @param password
	 * @return
	 */
	@RequestMapping(value="alterPasswordPage", method = RequestMethod.POST)
	public String alterPasswordSubmit(@RequestParam(value="account",defaultValue="")String account,@RequestParam(value="oldPassword",defaultValue="")String oldPassword,@RequestParam(value="password",defaultValue="")String password) {
		// 返回修改成功页面
		userService.alterPassword(account,MD5.md5(oldPassword),MD5.md5(password));
		return "redirect:/homePage";
	}
	/**
	 * 输入要找回密码的账号页面
	 * @param model
	 * @return
	 */
@RequestMapping(value="findPwAccountPage",method= RequestMethod.GET)
	public String findPwAccount(Model model) {
		
		model.addAttribute("index", 1);
		return "password/findPw";
	}

/**
 * 提交账号，并发送邮件
 * @param account
 * @param session
 * @return
 */
	@RequestMapping(value="findPwAccountPage",method= RequestMethod.POST)
	public String findPwAccountSubmit(@RequestParam(value="account",defaultValue="0")String account,HttpSession session) {
		//
		User user=userService.findEmail(account);
		if (user!=null) {
			session.setAttribute("email", user.getEmail());
			session.setAttribute("account", account);
			emailService.sendEmail(user,"找回密码验证", "find_pwd");
			return "redirect:/passwordPage/findPwValidatePage";
		}else {
			return "redirect:/passwordPage/findPwErrorPage";
		}
		
	}
	/**
	 * 进入验证码页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="findPwValidatePage",method= RequestMethod.GET)
	public String findPwValidate(Model model) {
		model.addAttribute("index", 2);
		return "password/findPw";
	}
	/**
	 * 验证输入的验证码是否正确
	 * @param identifyingCode
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findPwValidatePage",method= RequestMethod.POST)
	public String findPwValidateSubmit(@RequestParam(value="identifyingCode",defaultValue="0")String identifyingCode,HttpSession session) {
		//
		String email =(String) session.getAttribute("email");
		session.setAttribute("validate", "root");
		try {
			if (activateInfoService.findPwdCode(email, identifyingCode)) {
				
				return "redirect:/passwordPage/findPwAlterPage";
			}else {
				return "redirect:/passwordPage/findPwErrorPage";
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/passwordPage/findPwErrorPage";
		}
		
	}
	/**
	 * 找回密码错误页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="findPwErrorPage",method= RequestMethod.GET)
	public String findPwError(Model model) {
		model.addAttribute("error", "找回密码中途遇到一些错误，请重新尝试");
		return "error/error";
	}
	/**
	 * 修改密码页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="findPwAlterPage",method= RequestMethod.GET)
	public String findPwAlter(Model model) {
		model.addAttribute("index", 3);
		return "password/findPw";
	}
	
	/**
	 * 设置新的密码
	 * @param newPassword
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findPwAlterPage",method= RequestMethod.POST)
	public String findPwAlterSubmit(@RequestParam(value="newPassword",defaultValue="")String newPassword,HttpSession session) {
		//
		String account=(String) session.getAttribute("account");
		userService.findBackPassword(account,MD5.md5(newPassword));
	
		return "redirect:/passwordPage/findPwCompletePage";
	}
	
	/**
	 * 密码找回成功
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findPwCompletePage",method= RequestMethod.GET)
	public String findPwComplete(Model model,HttpSession session) {
		model.addAttribute("index", 4);
		session.removeAttribute("validate");
		return "password/findPw";
	}

	
}
