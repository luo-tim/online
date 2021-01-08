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
	
	/**
	 * 
	 * @param id
	 * @param tag
	 * @return
	 */
	public List<Job> findReleaseJob(String id, int tag){
		return jobInfoDAO.findReleaseJob(id, tag);
	}
	/**
	 * 
	 * @param id
	 * @param tag
	 * @return
	 */
	public List<Job> findSignupJob(String id, int tag){
		return jobInfoDAO.findSignupJob(id, tag);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Job> findHistoryJob(String id){
		return jobInfoDAO.findHistoryJob(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Job findJob(String id){
		
		return null;
	}
	
	public Job findBossJob(String id) {
		return jobInfoDAO.findBossJob(id);
	}
	
	/**
	 * 
	 * @param userId
	 * @param jobId
	 * @return
	 */
	public int findSignUpFlag(String userId,String jobId){
		
		return 0;
	}
	/**
	 * 
	 * @param jobId
	 * @return
	 */
	public String getBossId(String jobId) {
		return "";
	}
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<Job> findCompanyJobs(String companyId){
		return null;
	}
	/**
	 * 
	 * @param userId
	 * @param jobId
	 */
	public void successJobs(String userId,String jobId) {
		
	}
	/**
	 * 
	 * @param jobId
	 */
	public void failJobs(String jobId) {
		
	}
	/**
	 * 
	 * @param jobId
	 */
	public void deleteJob(String jobId) {
		
	}
	/**
	 * 插入工作
	 * @param job
	 * @return 工作id
	 */
	public String save(Job job) {
		return jobInfoDAO.insert(job);
	}
		
	public void finishJob(String workId) {
		jobInfoDAO.updateJobFinshed(workId);
	}
}
