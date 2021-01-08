/**
 * 
 */
package recruitSystem.service.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.view.BrowseJob;

/**
 * @author 72412
 *
 */
@Service("JobHistoryService")
public class JobHistoryService {
	
	@Autowired
	private JobInfoDAO jobInfoDAO;
	
	public int existHistory(String userId,String jobId) {
	return jobInfoDAO.existHistory(userId,jobId);
	}
	
	public void updateHistory(BrowseJob browseJob) {
		jobInfoDAO.updateHistory(browseJob);
	}
	
	public void insertHistory(BrowseJob browseJob) {
		jobInfoDAO.insertHistory(browseJob);
	}
}
