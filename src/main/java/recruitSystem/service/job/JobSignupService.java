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
 *
 */
@Service("JobSignupService")
public class JobSignupService {

	@Autowired
	private JobInfoDAO jobInfoDAO;
	public void insertWorkerSignup(SignUpJob signUpJob) {
		jobInfoDAO.insertWorkerSignup(signUpJob);
	}
}
