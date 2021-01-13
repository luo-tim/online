/**
 * 
 */
package recruitSystem.service.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.view.SignUpJob;

/**
 * @author 72412
 *申请工作服务
 */
@Service("JobSignupService")
public class JobSignupService {

	@Autowired
	private JobInfoDAO jobInfoDAO;
	/**
	 * 插入申请的工作
	 * @param signUpJob
	 */
	public void insertWorkerSignup(SignUpJob signUpJob) {
		jobInfoDAO.insertWorkerSignup(signUpJob);
	}
}
