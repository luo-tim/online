/**
 * 
 */
package recruitSystem.service.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.job.JobInfoDAO;
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
		return jobInfoDAO.insert(job);
	}
	

	
	public Job findBossJob(String id) {
		return jobInfoDAO.findBossJob(id);
	}
	
	public void finishJob(String workId) {
		jobInfoDAO.updateJobFinshed(workId);
	}
}
