/**
 * 
 */
package recruitSystem.action.myResume;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import recruitSystem.service.myResume.ResumeService;
import recruitSystem.view.Resume;
import recruitSystem.view.User;

/**
 * @author 72412 简历控制
 */
@Controller
@RequestMapping("/myResumePage")
public class MyResumeControl {

	@Autowired
	private ResumeService resumeService;

	/**
	 * 进入简历页面
	 * 
	 * @param workerId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String myResume(@RequestParam(value = "workerId", defaultValue = "0") String workerId, Model model,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		Resume resume = null;
		if (user!=null&&user.getIdentityId() >= 1) {
			resume = resumeService.findResume(workerId);
		} else {
			resume = resumeService.findResume(user.getId());
		}

		if (resume != null) {

			model.addAttribute("resume", resume);
			// System.out.println(resume.getIexperience()); jsp EL表达式获取属性时第一个字母似乎要小写
			return "resume/myResume";// 返回简历页面
		} else {

			return "redirect:/myResumePage/notFoundResumePage";// 返回错误提醒页面
		}

	}

	/**
	 * 提示没有简历界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notFoundResumePage", method = RequestMethod.GET)
	public String tipResume(Model model) {
		model.addAttribute("notResume", "目前没有简历");
		return "resume/notResume";
	}

	/**
	 * 进入简历修改页面
	 * 
	 * @param workerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/alterPage", method = RequestMethod.GET)
	public String alterResume(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Resume resume = resumeService.findResume(user.getId());

		if (resume != null) {
			model.addAttribute("resume", resume);
		}

		return "resume/alterResume";
	}

	/**
	 * 提交简历
	 * 
	 * @param name
	 * @param nation
	 * @param education
	 * @param birth
	 * @param height
	 * @param sex
	 * @param school
	 * @param politic
	 * @param phone
	 * @param email
	 * @param address
	 * @param educationbg
	 * @param practice
	 * @param skills
	 * @param campus
	 * @param self
	 * @param session
	 * @return
	 * @throws ParseException
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
			@RequestParam(value = "self", defaultValue = "") String self,
			@RequestParam(value = "photo", defaultValue = "") CommonsMultipartFile photo, HttpSession session,
			HttpServletRequest request) throws ParseException {

		User user = (User) session.getAttribute("user");
		Resume resume = new Resume();
		if (phone != null) {
			String uploadFileName = photo.getOriginalFilename();
			String fileSuffixName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
			String uploadPath = request.getServletContext().getRealPath("/static/photo");
			File realPath = new File(uploadPath);
			if (!realPath.exists()) {
				realPath.mkdir();
			}
			String fileName = name + phone + "." + fileSuffixName;// 保存的文件名称为公司名称加文件的后缀格式
			try {
				InputStream is = photo.getInputStream(); // 文件输入流
				OutputStream os = new FileOutputStream(new File(realPath, fileName)); // 文件输出流

				// 读取写出
				int len = 0;
				byte[] buffer = new byte[1024];
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
					os.flush();
				}
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resume.setPhoto(fileName);
		}

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
