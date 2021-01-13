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

	/**
	 * 获取简历
	 * @param userId
	 * @return
	 */
	Resume findResume(@Param("userId")String userId);
	/**
	 * 判断简历是存在
	 * @param userId
	 * @return
	 */
	int existResume(@Param("userId") String userId);
	/**
	 * 更新简历
	 * @param resume
	 */
	void updateResume(@Param("resume")Resume resume);
	/**
	 * 插入简历
	 * @param resume
	 */
	void insert(@Param("resume") Resume resume);
}
