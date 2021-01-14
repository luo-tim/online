/**
 * 
 */
package recruitSystem.service.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.service.news.NewsService;
import recruitSystem.view.Information;
import recruitSystem.view.SignUpJob;

/**
 * @author 72412
 *申请工作服务
 */
@Service("JobSignupService")
public class JobSignupService {

	@Autowired
	private JobInfoDAO jobInfoDAO;
	@Autowired
	private JobService jobService;
	@Autowired
	private NewsService newsService;
	/**
	 * 插入申请的工作
	 * @param signUpJob
	 */
	@Async
	@Transactional
	public void insertWorkerSignup(SignUpJob signUpJob) {
		jobInfoDAO.insertWorkerSignup(signUpJob);
		String bossId = jobService.getBossId(signUpJob.getJobId());// 获取老板的id
		Information information = new Information();// 发送消息
	
		information.setSendId(signUpJob.getUserId());
		information.setReceiveId(bossId);
		information.setContext("我申请了你的工作，请查看我的简历");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		information.setPostTime(dateFormat.format(new Date()));
		newsService.sendMessage(information);
	}
}
