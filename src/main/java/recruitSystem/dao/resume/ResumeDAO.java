/**
 * 
 */
package recruitSystem.dao.resume;

import org.apache.ibatis.annotations.Param;
import recruitSystem.view.Resume;

/**
 * @author 72412
 *
 */

public interface ResumeDAO {

	Resume findResume(@Param("userId")String userId);
	int existResume(@Param("userId") String userId);
	void updateResume(@Param("resume")Resume resume);
	void insert(@Param("resume") Resume resume);
}
