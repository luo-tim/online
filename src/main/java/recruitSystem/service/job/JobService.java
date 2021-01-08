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
	
	public Job findJob(String id){
		
		return null;
	}
	
	public int findSignUpFlag(String userId,String jobId){
		
		return 0;
	}
	public String getBossId(String jobId) {
		return "";
	}
	
	public List<Job> findCompanyJobs(String companyId){
		return null;
	}
	
	public void successJobs(String userId,String jobId) {
		
	}
	
	public void failJobs(String jobId) {
		
	}
	
	public void deleteJob(String jobId) {
		
	}
	public int save(Job job) {
		return 0;
	}
	

	
	public Job findBossJob(String id) {
		return null;
	}
	
	public int finishJob(String workId) {
		return 0;
	}
}
