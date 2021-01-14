/**
 * 
 */
package recruitSystem.action.releaseRecruitment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.job.JobService;
import recruitSystem.service.news.NewsService;
import recruitSystem.service.user.UserService;
import recruitSystem.view.Information;
import recruitSystem.view.Job;
import recruitSystem.view.User;

/**
 * @author 72412
 *  老板工作管理控制
 */
@Controller
@RequestMapping("/releaseRecruitmentPage")
public class ReleaseRecruitmentController {

	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private JobService jobService;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	
	/**
	 * 进入发布工作页面
	 * 
	 * @return "releaseRecruitment"
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String releaseRecruitment() {
		return "job/releaseRecruitment";
	}

	/**
	 * 发布工作,发布完工作后就跳转到工作详情页面
	 * 
	 * @param jobName,
	 * @param jobType,
	 * @param jobIntroduce,
	 * @param jobSalary,
	 * @param city,
	 * @param jobAddress,
	 * @param jobRequest,
	 * @param experience,
	 * @param education,
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postRecruitment(@RequestParam(value = "jobName", defaultValue = "") String jobName,
			@RequestParam(value = "jobType", defaultValue = "") String jobType,
			@RequestParam(value = "jobIntroduce", defaultValue = "") String jobIntroduce,
			@RequestParam(value = "jobSalary", defaultValue = "") String jobSalary,
			@RequestParam(value = "city", defaultValue = "") String city,
			@RequestParam(value = "jobAddress", defaultValue = "") String jobAddress,
			@RequestParam(value = "jobRequest", defaultValue = "") String jobRequest,
			@RequestParam(value = "experience", defaultValue = "") String experience,
			@RequestParam(value = "education", defaultValue = "") String education, HttpSession session) {
		User boss = (User) session.getAttribute("user");
//		Job job = new Job(boss.getId(), new Date(), jobName, jobIntroduce, jobAddress, jobSalary, city, jobType,
//				experience, education, jobRequest);
		Job job = new Job();
		job.setBossId(boss.getId());
		job.setReleaseTime(sdf.format(new Date()));
		job.setJobName(jobName);
		job.setJobDescription(jobIntroduce);
		job.setWorkAddress(jobAddress);
		job.setSalary(jobSalary);
		job.setCity(city);
		job.setJobType(jobType);
		job.setExperience(experience);
		job.setEducation(education);
		job.setJobRequest(jobRequest);
		String id = jobService.save(job);
		System.out.println("工作id： "+id);
		return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + id;// 重定向到老板查看工作的页面
	}

	/**
	 * 老板查看工作的页面
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/bossWorkDetailPage", method = RequestMethod.GET)
	public String bossWorkDetail(@RequestParam(value = "id", defaultValue = "0") String id, Model model,
			HttpSession session) {
		User boss = (User) session.getAttribute("user");
		if (boss != null) {
			Job job = jobService.findBossJob(id);
			if (job != null) {
				
				model.addAttribute("job", job);
				List<User> workers = userService.findSignupUsers(id);
				model.addAttribute("workers", workers);
				return "job/bossWorkDetail";
			} else {
				return "redirect:/releaseRecruitmentPage/jobNotPage";
			}
		} else {
			return "redirect:/homePage";
		}
	}
	/**
	 *  工作不存在页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/jobNotPage", method = RequestMethod.GET)
	public String UserExist(Model model) {
		model.addAttribute("error", "该工作不存在");
		return "error/error";
	}

	/**
	 * 结束工作招聘
	 * @param workId
	 * @return
	 */
	@RequestMapping(value = "/finishRecruitmentPage", method = RequestMethod.GET)
	public String finishRecruitmentPage(@RequestParam(value = "workId", defaultValue = "0") String workId) {
		jobService.finishJob(workId);		
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + workId;
		
	}

	/**
	 * 通过申请人
	 * @param workerId
	 * @param employId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/passSignupPage", method = RequestMethod.GET)
	public String passSignup(@RequestParam(value = "workerId", defaultValue = "0") String workerId,
			@RequestParam(value = "employId", defaultValue = "0") String employId, HttpSession session) {
		// 向打工人发送通过消息
		 	userService.alterSignUpFlag(1,workerId, employId,sdf.format(new Date()));
	
			User user = (User) session.getAttribute("user");// 获取老板的用户id
//			int workerUser = userService.getWorkerId(workerId);
//			Information information = new Information(user.getId(), workerUser, new Date(), "我通过了你的申请，请及时联系我");// 发送消息
			Information information = new Information();
			information.setSendId(user.getId());
			information.setReceiveId(workerId);
			information.setPostTime(sdf.format(new Date()));
			information.setContext("我通过了你的申请，请及时联系我");
			newsService.sendMessage(information);
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + employId;
		}
	

	/**
	 * 拒绝申请人
	 * @param workerId
	 * @param employId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/refuseSignupPage", method = RequestMethod.GET)
	public String refuseSignup(@RequestParam(value = "workerId", defaultValue = "0") String workerId,
			@RequestParam(value = "employId", defaultValue = "0") String employId, HttpSession session) {
		// 向打工人发送拒绝消息
		 userService.alterSignUpFlag(2, workerId, employId, sdf.format(new Date()));
		
			User user = (User) session.getAttribute("user");// 获取老板的用户id
//			int workerUser = userService.getWorkerId(workerId);
//			Information information = new Information(user.getId(), workerUser, new Date(), "不好意思，你不符合我们所需标准");// 发送消息
			Information information = new Information();
			information.setSendId(user.getId());
			information.setReceiveId(workerId);
			information.setPostTime(sdf.format(new Date()));
			information.setContext("不好意思，你不符合我们所需标准");
			newsService.sendMessage(information);
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + employId;
		
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
		
		model.addAttribute("userAccount", user);
		return "manager/userAccount";
	}
	
}
