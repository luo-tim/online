/**
 * 
 */
package recruitSystem.service.myResume;

import org.springframework.stereotype.Service;

import recruitSystem.view.Resume;

/**
 * @author 72412
 *简历服务
 */
@Service("ResumeService")
public class ResumeService {

	
	public Resume findResume(String userId) {
		return null;
	}
	
	public int existResume(String userId) {
		return 0;
	}
	
	public int updateResume(Resume resume) {
		
		return 0;
	}
	public void insert(Resume resume) {
		
	}
	
}
