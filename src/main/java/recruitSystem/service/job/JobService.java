/**
 * 
 */
package recruitSystem.service.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Job;

/**
 * @author 72412
 *
 */
@Service("JobService")
public class JobService {

	@Autowired
	private JobInfoDAO jobInfoDAO;
	
	
	public List<Job> findReleaseJob(String id, int tag){
		return jobInfoDAO.findReleaseJob(id, tag);
	}
	
	public List<Job> findSignupJob(String id, int tag){
		return jobInfoDAO.findSignupJob(id, tag);
	}
	
	public List<Job> findHistoryJob(String id){
		return jobInfoDAO.findHistoryJob(id);
	}
	
	public Job findJob(String jobId){
		
		return jobInfoDAO.findJob(jobId);
	}
	
	public String findSignUpFlag(String userId,String jobId){
		
		return jobInfoDAO.findSignUpFlag(userId,jobId);
	}
	public String getBossId(String jobId) {
		return jobInfoDAO.getBossId(jobId);
	}
	
	public List<Job> findCompanyJobs(String companyId){
		return jobInfoDAO.findCompanyJobs(companyId);
	}
	
	public void successJobs(String userId,String jobId) {
		jobInfoDAO.successJobs(userId,jobId);
	}
	
	public void failJobs(String jobId) {
		jobInfoDAO.failJobs(jobId);
	}
	
	public void deleteJob(String jobId) {
		jobInfoDAO.deleteJob(jobId);
	}
	public String save(Job job) {
		 jobInfoDAO.insert(job);
		 return job.getId();
	}
	

	
	public Job findBossJob(String id) {
		return jobInfoDAO.findBossJob(id);
	}
	
	public void finishJob(String workId) {
		jobInfoDAO.updateJobFinshed(workId);
	}
	
	public 	PaginationSupport<Job>  findJobs(int pageNo,String query,String city,String type) {
		
		int totalCount = jobInfoDAO.jobCount("1", query, city, type);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<Job> jobs;
		
		jobs=jobInfoDAO.findJobs(startIndex, query, city, type);
		
		PaginationSupport<Job> pj = new PaginationSupport<Job>(jobs, totalCount, startIndex, pageNo);

		return pj;
	}
	
	public PaginationSupport<Job> findJobs(int pageNo,String tag){
		int totalCount=0;
		jobInfoDAO.jobCount(tag, null, null, null);
		int startIndex=PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<Job> jobs;
		jobs = jobInfoDAO.findJobs(startIndex,null, null, null);
		PaginationSupport<Job> pj=new PaginationSupport<Job>(jobs, totalCount,startIndex,pageNo);
		return pj;
	
	}
}
