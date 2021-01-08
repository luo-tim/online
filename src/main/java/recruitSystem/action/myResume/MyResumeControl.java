/**
 * 
 */
package recruitSystem.action.myResume;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.myResume.ResumeService;
import recruitSystem.view.Resume;
import recruitSystem.view.User;

/**
 * @author 72412
 *简历控制
 */
@Controller
@RequestMapping("/myResumePage")
public class MyResumeControl {

	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 进入简历页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String myResume( Model model,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
	
		Resume resume = resumeService.findResume(user.getId());
		if (resume!=null) {
			
			model.addAttribute("resume", resume);
			// System.out.println(resume.getIexperience()); jsp EL表达式获取属性时第一个字母似乎要小写
			return "resume/myResume";// 返回简历页面
		} else {

			return "redirect:/myResumePage/notFoundResumePage";// 返回错误提醒页面
		}

}
	/*
	 * 提示没有简历界面
	 */
	@RequestMapping(value = "/notFoundResumePage", method = RequestMethod.GET)
	public String tipResume(Model model) {
		model.addAttribute("notResume", "目前没有简历");
		return "resume/notResume";
	}
	

	/**
	 * 进入简历修改页面
	 */
	@RequestMapping(value = "/alterPage", method = RequestMethod.GET)
	public String alterResume(@RequestParam(value = "workerId", defaultValue = "0") String workerId, Model model) {

		Resume resume = resumeService.findResume(workerId);
		if (resume !=null) {
		
			model.addAttribute("resume", resume);

		}

		return "resume/alterResume";
	}
	
	/**
	 * 提交简历
	 */
	@RequestMapping(value = "/alterPage", method = RequestMethod.POST)
	public String submitResume(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "nation", defaultValue = "") String nation,
			@RequestParam(value = "education", defaultValue = "") String education,
			@RequestParam(value = "birth", defaultValue = "") String birth,
			@RequestParam(value = "height", defaultValue = "") String height,
			@RequestParam(value = "sex", defaultValue = "") String sex,
			@RequestParam(value = "school", defaultValue = "") String school,
			@RequestParam(value = "politic", defaultValue = "") String politic,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "educationbg", defaultValue = "") String educationbg,
			@RequestParam(value = "practice", defaultValue = "") String practice,
			@RequestParam(value = "skills", defaultValue = "") String skills,
			@RequestParam(value = "campus", defaultValue = "") String campus,
			@RequestParam(value = "self", defaultValue = "") String self, HttpSession session) throws ParseException {
		
		User user = (User) session.getAttribute("user");
		Resume resume=new Resume();
		resume.setName(name);
		resume.setNation(nation);
		resume.setEducation(education);
		resume.setDateOfBirth(birth);
		resume.setHeight(height);
		resume.setSex(sex);
		resume.setSchool(school);
		resume.setPoliticsStatus(politic);
		resume.setPhone(phone);
		resume.setEmail(email);
		resume.setAddress(address);
		resume.setEducationBg(educationbg);
		resume.setSkills(skills);
		resume.setSelf(self);
		resume.setIexperience(practice);
		resume.setSexperience(campus);
		resume.setUserId(user.getId());
		int row = resumeService.existResume(user.getId());
		if (row != 0) {// 修改简历
			resumeService.updateResume(resume);
				
		} else {// 填写简历
			resumeService.insert(resume);
		}

		return "redirect:/myResumePage";// 跳转到简历信息
	}
	
	

}
