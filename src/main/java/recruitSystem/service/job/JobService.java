/**
 * 
 */
package recruitSystem.service.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.news.NewsService;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Information;
import recruitSystem.view.Job;

/**
 * @author 72412
 *工作的服务层
 */
@Service("JobService")
public class JobService {

	@Autowired
	private JobInfoDAO jobInfoDAO;

	@Autowired
	private CompanyService companyService;
	@Autowired
	private NewsService newsService;
	
	/**
	 * 查找发布的工作
	 * @param id
	 * @param tag
	 * @return
	 */
	public List<Job> findReleaseJob(String id, String tag){
		return jobInfoDAO.findReleaseJob(id, tag);
	}
	
	/**
	 * 查找申请的工作
	 * @param id
	 * @param tag
	 * @return
	 */
	public List<Job> findSignupJob(String id, String tag){
		return jobInfoDAO.findSignupJob(id, tag);
	}
	
	/**
	 * 查找浏览记录
	 * @param id
	 * @return
	 */
	public List<Job> findHistoryJob(String id){
		return jobInfoDAO.findHistoryJob(id);
	}
	/**
	 * 根据工作id获取工作信息
	 * @param jobId
	 * @return
	 */
	public Job findJob(String jobId){
		
		return jobInfoDAO.findJob(jobId);
	}
	
	/**
	 * 查找申请的状态
	 * @param userId
	 * @param jobId
	 * @return
	 */
	public String findSignUpFlag(String userId,String jobId){
		
		return jobInfoDAO.findSignUpFlag(userId,jobId);
	}
	/**
	 * 根据工作id获取老板id
	 * @param jobId
	 * @return
	 */
	public String getBossId(String jobId) {
		return jobInfoDAO.getBossId(jobId);
	}
	
	/**
	 * 获取公司的工作
	 * @param companyId
	 * @return
	 */
	public List<Job> findCompanyJobs(String companyId){
		return jobInfoDAO.findCompanyJobs(companyId);
	}
	/**
	 * 工作审核通过
	 * @param userId
	 * @param jobId
	 */
	@Transactional
	public void successJobs(String userId,String jobId) {
		jobInfoDAO.successJobs(userId,jobId);
		String bossId=getBossId(jobId);
		companyService.updateJobNum(bossId,1);
		Information information = new Information();// 发送消息
		information.setContext("你的工作发布已通过，请查看");
		information.setSendId(userId);
		information.setReceiveId(bossId);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		information.setPostTime(dateFormat.format(new Date()));
		newsService.sendMessage(information);
	}
	
	/**
	 * 工作审核失败
	 * @param jobId
	 * @param sendId
	 */
	@Transactional
	public void failJobs(String jobId,String sendId) {
		String bossId=getBossId(jobId);
		jobInfoDAO.failJobs(jobId);
		System.out.println("工作:"+jobId);
		
		System.out.println("bossId:"+bossId);
		Information information = new Information();// 发送消息
		information.setContext("你的工作发布因违反相关规定，被拒绝。如有问题请联系客服");
		information.setSendId(sendId);
		information.setReceiveId(bossId);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		information.setPostTime(dateFormat.format(new Date()));
		newsService.sendMessage(information);
	}
	



	/**
	 * 删除工作
	 * @param jobId
	 * @param tag
	 */
	@Transactional
	public void deleteJob(String jobId,int tag) {
		jobInfoDAO.deleteJob(jobId);
		if (tag==1) {
			String bossId= findBossId(jobId);
			companyService.updateJobNum(bossId,-1);
		}
		
	}
	/**
	 * 根据job  id获取bossId
	 * @param jobId
	 * @return
	 */
	public String findBossId(String jobId) {
		return jobInfoDAO.findBossId(jobId);
	}
	/**
	 * 插入工作
	 * @param job
	 * @return
	 */
	public String save(Job job) {
		 jobInfoDAO.insert(job);
		 return job.getId();
	}
	

	/**
	 * 查找老板的工作
	 * @param id
	 * @return
	 */
	public Job findBossJob(String id) {
		return jobInfoDAO.findBossJob(id);
	}
	
	/**
	 * 结束招聘
	 * @param workId
	 */
	@Transactional
	public void finishJob(String workId) {
		jobInfoDAO.updateJobFinshed(workId);
		String bossId = jobInfoDAO.findBossId(workId);
		companyService.updateJobNum(bossId, -1);
	}
	
	/**
	 * 筛选工作，获取工作列表
	 * @param pageNo
	 * @param query
	 * @param city
	 * @param type
	 * @return
	 */
	
	public 	PaginationSupport<Job>  findJobs(int pageNo,String query,String city,String type) {
		
		int totalCount = jobInfoDAO.jobCount("1", query, city, type);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<Job> jobs;
		
		jobs=jobInfoDAO.findJobs(startIndex, "1",query, city, type);
		
		PaginationSupport<Job> pj = new PaginationSupport<Job>(jobs, totalCount, startIndex, pageNo);

		return pj;
	}
	
	/**
	 * 获取工作列表
	 * @param pageNo
	 * @param tag
	 * @return
	 */
	public PaginationSupport<Job> findJobs(int pageNo,String tag){
		int totalCount=jobInfoDAO.jobCount(tag, null, null, null);
		int startIndex=PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<Job> jobs;
		jobs = jobInfoDAO.findJobs(startIndex,tag,null, null, null);
		PaginationSupport<Job> pj=new PaginationSupport<Job>(jobs, totalCount,startIndex,pageNo);
		return pj;
	
	}
	
	/**
	 * 获取工作的状态
	 * @param jobId
	 * @return
	 */
	public String findFlag(String jobId) {
		return jobInfoDAO.findFlag(jobId);
	}
}
