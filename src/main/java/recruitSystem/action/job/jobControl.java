/**
 * 
 */
package recruitSystem.action.job;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sf.json.util.NewBeanInstanceStrategy;
import recruitSystem.service.job.JobHistoryService;
import recruitSystem.service.job.JobService;
import recruitSystem.service.job.JobSignupService;
import recruitSystem.service.news.NewsService;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Information;
import recruitSystem.view.Job;
import recruitSystem.view.User;

/**
 * @author 72412
 *招聘信息控制
 */
@Controller
@RequestMapping("/employmentPage")
public class jobControl {

	@Autowired
	private JobService jobService;
	@Autowired
	private JobHistoryService jobHistoryService;
	@Autowired
	private JobSignupService jobSignupService;
	@Autowired
	private NewsService newsService;
	/*
	 * 进入工作列表页面,根据查询来分页
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String employment(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "query", defaultValue = "") String query,
			@RequestParam(value = "pro", defaultValue = "省份") String pro,
			@RequestParam(value = "city", defaultValue = "城市") String city,
			@RequestParam(value = "type", defaultValue = "工作类型") String type, Model model) {
		// 注意要分页,根据这三个参数来进行筛选
		// System.out.println(query+"ss");
		// System.out.println(city);
//分页
//		PaginationSupport<Job> jobs = jobService.findJobs(pageNo, query, city, type);
//		model.addAttribute("pages", jobs);
		return "workList";
	}
	
	/*
	 * 搜索工作
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String search(@RequestParam(value = "query", defaultValue = "") String query,
			@RequestParam(value = "pro", defaultValue = "省份") String pro,
			@RequestParam(value = "city", defaultValue = "城市") String city,
			@RequestParam(value = "type", defaultValue = "全部") String type, RedirectAttributes attr)
			throws UnsupportedEncodingException {
		// 疑问，不知道为什么post方法变成了query=, 估计是select和js的原因的原因
		query = query.substring(query.lastIndexOf(",") + 1, query.length());
		pro = pro.split(",")[pro.split(",").length - 1];
		city = city.split(",")[city.split(",").length - 1];
		type = type.split(",")[type.split(",").length - 1];
		attr.addAttribute("type", type);
		attr.addAttribute("pro", pro);
		attr.addAttribute("city", city);
		attr.addAttribute("query", query);
		// System.out.println("post"+pro+" =="+city+"== "+type);//中文url拼接重定向乱码
		return "redirect:/employmentPage";// 重定向到get方法
		// return
		// "redirect:/employmentPage?type="+type+"&pro="+pro+"&city="+city+"&query="+query;//重定向到get方法
	}
	
	/**
	 * 进入工作详情页面
	 */
	@RequestMapping(value = "/workDetailPage", method = RequestMethod.GET)
	public String workDetail(@RequestParam(value = "id", defaultValue = "0") String id, Model model, HttpSession session) {
		Job job = jobService.findJob(id);
		if (job != null) {// 工作不为空
			model.addAttribute("job", job);
			// 如果是打工人登录，就创建一个新的model存储相关信息
			User user = (User) session.getAttribute("user");
			int flag = 0;
			if (user.getIdentityId() == 0) {// 如果是打工人登录，查询用户是否已经报名，将浏览记录添加
				//
				int row = jobHistoryService.existHistory(user.getId(), id);
				if (row == 1) {// 之前浏览过
					flag = jobService.findSignUpFlag(user.getId(), id);// 查询用户是否已经报名
					jobHistoryService.updateHistory(user.getId(), id, new Date());// 更新浏览时间
				} else {// 第一次浏览
						// 向历史中插入数据
					jobHistoryService.insertHistory(user.getId(), id, new Date());// 插入浏览记录
				}
			}
			model.addAttribute("flag", flag);// 用来判断用户是否已经报名，1是审核中，2是审核通过，3是审核失败
			return "job/workDetail";
		} else {// 工作为空，则重定向到列表
			return "redirect:/employmentPage";
		}

	}

	
	/*
	 * 报名竞选工作 id是工作的id，f是是否在招聘的id
	 */
	@RequestMapping(value = "signupWorkPage", method = RequestMethod.GET)
	public String signupWork(@RequestParam(value = "id", defaultValue = "0") String id,
			@RequestParam(value = "f", defaultValue = "2") int f, Model model, HttpSession session) {
		if (f == 0) {// 招聘中
			User user = (User) session.getAttribute("user");
			if ( user.getIdentityId()==0) {// 是打工人则报名
				
				jobSignupService.insertWorkerSignup(user.getId(), id, new Date());
				
				String bossId = jobService.getBossId(id);// 获取老板的id
				Information information = new Information();// 发送消息
			
				information.setSendId(user.getId());
				information.setReceiveId(bossId);
				information.setContext("我申请了你的工作，请查看我的简历");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
				information.setPostTime(dateFormat.format(new Date()));
				newsService.sendMessage(information);
				return "redirect:/employmentPage/workDetailPage?id=" + id;// 重新进入到页面中
			} else {// 不是打工人禁止报名
				model.addAttribute("signupError", "身份错误，无法申请");
				return "notFound";// 进入到错误提醒页面
			}
		} else {// 招聘结束
			model.addAttribute("signupError", "工招聘已经结束，无法报名");
			return "notFound";// 进入到错误提醒页面
		}

	}

}