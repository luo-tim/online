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
 * 发布工作控制器
 * @author LJTTT
 *
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
		return "releaseRecruitment";
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
		User boss = (User) session.getAttribute("boss");
//		Job job = new Job(boss.getId(), new Date(), jobName, jobIntroduce, jobAddress, jobSalary, city, jobType,
//				experience, education, jobRequest);
		Job job = new Job();
		job.setBossId(boss.getId());
		job.setReleaseTime(sdf.format(new Date()));
		job.setJobName(jobName);
		job.setJobDescription(jobIntroduce);
		job.setWorkaddress(jobAddress);
		job.setSalary(jobSalary);
		job.setCity(city);
		job.setJobType(jobType);
		job.setExperience(experience);
		job.setEducation(education);
		job.setJobRequest(jobRequest);
		int id = jobService.save(job);
		return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + id;// 重定向到老板查看工作的页面
	}

	/**
	 * 老板查看工作的页面
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/bossWorkDetailPage", method = RequestMethod.GET)
	public String bossWorkDetail(@RequestParam(value = "id", defaultValue = "0") int id, Model model,
			HttpSession session) {
		User boss = (User) session.getAttribute("boss");
		if (boss != null) {
			int row = jobService.existJob(id);
			if (row != 0) {
				Job job = jobService.findBossJob(id);
				model.addAttribute("job", job);
				List<User> workers = userService.findSignupUsers(id);
				model.addAttribute("workers", workers);
				return "bossWorkDetail";
			} else {
				return "redirect:/newsPage/notNewsPage";
			}
		} else {
			return "redirect:/newsPage/notNewsPage";
		}
	}

	/**
	 * 结束工作招聘,传入工作的，来结束,结束成功则返回详情页面，失败则返回错误提醒页面
	 * 
	 * @param workId
	 */
	@RequestMapping(value = "/finishRecruitmentPage", method = RequestMethod.GET)
	public String finishRecruitmentPage(@RequestParam(value = "workId", defaultValue = "0") int workId) {
		int row = jobService.finishJob(workId);
		if (row == 0) {
			return "redirect:/newsPage/notNewsPage";
		} else {
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + workId;
		}
	}

	/**
	 * 通过申请人
	 * 
	 * @param workerId
	 */
	@RequestMapping(value = "/passSignupPage", method = RequestMethod.GET)
	public String passSignup(@RequestParam(value = "workerId", defaultValue = "0") int workerId,
			@RequestParam(value = "employId", defaultValue = "0") int employId, HttpSession session) {
		// 向打工人发送通过消息
		int row = userService.successWorker(2, workerId, employId, new Date());
		if (row == 0) {
			return "redirect:/newsPage/notNewsPage";
		} else {
			User user = (User) session.getAttribute("user");// 获取老板的用户id
//			int workerUser = userService.getWorkerId(workerId);
//			Information information = new Information(user.getId(), workerUser, new Date(), "我通过了你的申请，请及时联系我");// 发送消息
			Information information = new Information();
			information.setSendId(user.getId());
			information.setReceiveId(workerId);
			information.setPostTime(sdf.format(new Date()));
			information.setContext("我通过了你的申请，请及时联系我");
			newsService.save(information);
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + employId;
		}
	}

	/**
	 * 拒绝申请人
	 * 
	 * @param workerId
	 * @param employId
	 */
	@RequestMapping(value = "/refuseSignupPage", method = RequestMethod.GET)
	public String refuseSignup(@RequestParam(value = "workerId", defaultValue = "0") int workerId,
			@RequestParam(value = "employId", defaultValue = "0") int employId, HttpSession session) {
		// 向打工人发送拒绝消息
		int row = userService.successWorker(3, workerId, employId, new Date());
		if (row == 0) {
			return "redirect:/newsPage/notNewsPage";
		} else {
			User user = (User) session.getAttribute("user");// 获取老板的用户id
//			int workerUser = userService.getWorkerId(workerId);
//			Information information = new Information(user.getId(), workerUser, new Date(), "不好意思，你不符合我们所需标准");// 发送消息
			Information information = new Information();
			information.setSendId(user.getId());
			information.setReceiveId(workerId);
			information.setPostTime(sdf.format(new Date()));
			information.setContext("不好意思，你不符合我们所需标准");
			newsService.save(information);
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id=" + employId;
		}
	}
}
