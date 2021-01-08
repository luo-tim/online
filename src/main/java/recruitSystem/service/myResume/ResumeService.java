/**
 * 
 */
package recruitSystem.service.myResume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.resume.ResumeDAO;
import recruitSystem.view.Resume;

/**
 * @author 72412
 *简历服务
 */
@Service("ResumeService")
public class ResumeService {
	
	@Autowired
	private ResumeDAO resumeDAO;
	
	public Resume findResume(String userId) {
		return resumeDAO.findResume(userId);
	}
	
	public int existResume(String userId) {
		return resumeDAO.existResume(userId);
	}
	
	public void updateResume(Resume resume) {
		
		resumeDAO.updateResume(resume);
	}
	public void insert(Resume resume) {
		resumeDAO.insert(resume);
	}
	
}
