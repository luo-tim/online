/**
 * 
 */
package recruitSystem.action.management;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.job.JobService;
import recruitSystem.service.news.NewsService;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Information;
import recruitSystem.view.Job;
import recruitSystem.view.User;

/**
 * @author 72412
 *审核招聘信息
 */

@Controller
@RequestMapping("/managerPage/checkRecruitmentPage")
public class ManagementCheckRecruitmentController {
	@Autowired
	private JobService jobService;
	@Autowired
	private NewsService newsService;

	
	/**
	 * 工作列表
	 * @param pageNo
	 * @param tag
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String checkRecruitment(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value = "tag", defaultValue = "all") String tag, Model model) {
		PaginationSupport<Job> jobs = jobService.findJobs(pageNo,tag);
		model.addAttribute("pages", jobs);
		return "manager/checkRecruitment";
	}
	

	/**
	 * 审核通过
	 * @param workId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/successRecruitmentPage", method = RequestMethod.GET)
	public String successRecruitment(@RequestParam(value = "workId", defaultValue = "0") String workId,
			HttpSession session) {
		
		//工作数量加一
			
			User user = (User) session.getAttribute("user");
		 	jobService.successJobs(user.getId(), workId);
		 
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage?id="+workId;
		
	}
	
	/**
	 * 审核不通过
	 * @param workId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/failRecruitmentPage", method = RequestMethod.GET)
	public String failRecruitment(@RequestParam(value = "workId", defaultValue = "0") String workId,HttpSession session) {
		jobService.failJobs(workId);
		
			User user = (User) session.getAttribute("user");
			String bossId=jobService.getBossId(workId);
			
			Information information = new Information();// 发送消息
			information.setContext("你的工作发布因违反相关规定，被拒绝。如有问题请联系客服");
			information.setSendId(user.getId());
			information.setReceiveId(bossId);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			information.setPostTime(dateFormat.format(new Date()));
			newsService.sendMessage(information);
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage";
		
	}
	
	
	/**
	 * 删除工作
	 * @param workId
	 * @param tag
	 * @return
	 */
	@RequestMapping(value = "/deleteRecruitmentPage", method = RequestMethod.GET)
	public String deleteRecruitment(@RequestParam(value = "workId", defaultValue = "0") String workId,@RequestParam(value = "tag", defaultValue = "0") int tag) {
		 	jobService.deleteJob(workId,tag);
	
			return "redirect:/releaseRecruitmentPage/bossWorkDetailPage";
		
	}

	/**
	 * 查看招聘的详情页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recruitmentDetailPage", method = RequestMethod.GET)
	public String recruitmentDetail(@RequestParam(value = "id", defaultValue = "0") String id, Model model) {
		Job job = jobService.findJob(id);
		if (job != null) {
			model.addAttribute("job", job);
			return "job/bossWorkDetail";
		} else {
			return "redirect:/managerPage/checkRecruitmentPage/notJobPage";
		}

	}
	
	/**
	 * 工作不存在页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notJobPage", method = RequestMethod.GET)
	public String UserExist(Model model) {
		model.addAttribute("error", "该工作不存在");
		return "error/error";
	}

}
