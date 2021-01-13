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
	
	/**
	 * 获取简历信息
	 * @param userId
	 * @return
	 */
	public Resume findResume(String userId) {
		return resumeDAO.findResume(userId);
	}
	
	/**
	 * 判断简历是否存在
	 * @param userId
	 * @return
	 */
	public int existResume(String userId) {
		return resumeDAO.existResume(userId);
	}
	
	/**
	 * 更新简历
	 * @param resume
	 */
	public void updateResume(Resume resume) {
		
		resumeDAO.updateResume(resume);
	}
	
	/**
	 * 插入简历
	 * @param resume
	 */
	public void insert(Resume resume) {
		resumeDAO.insert(resume);
	}
	
}
