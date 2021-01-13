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
 *浏览历史的服务层
 */
@Service("JobHistoryService")
public class JobHistoryService {
	
	@Autowired
	private JobInfoDAO jobInfoDAO;
	
	/**
	 * 判断是否浏览过该工作
	 * @param userId
	 * @param jobId
	 * @return
	 */
	public int existHistory(String userId,String jobId) {
	return jobInfoDAO.existHistory(userId,jobId);
	}
	/**
	 * 更新浏览记录
	 * @param browseJob
	 */
	public void updateHistory(BrowseJob browseJob) {
		jobInfoDAO.updateHistory(browseJob);
	}
	
	/**
	 * 插入浏览记录
	 * @param browseJob
	 */
	public void insertHistory(BrowseJob browseJob) {
		jobInfoDAO.insertHistory(browseJob);
	}
}
