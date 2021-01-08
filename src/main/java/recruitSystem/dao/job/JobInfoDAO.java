/**
 * 
 */
package recruitSystem.dao.job;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.Job;

/**
 * @author 72412
 *
 */
public interface JobInfoDAO {

	List<Job> findReleaseJob(@Param("jobId") String jobId,@Param("tag") int tag);
	List<Job> findSignupJob(@Param("jobId") String jobId,@Param("tag") int tag);
	List<Job> findHistoryJob(@Param("jobId") String jobId);
	/**
	 * 插入工作
	 * @param job
	 * @return 工作id
	 */
	String insert(Job job);
	/**
	 * 老板查找工作（除了已删除）
	 * @param id
	 * @return
	 */
	Job findBossJob(@Param("jobId")String jobId);
	
	void updateJobFinshed(@Param("jobId")String jobId);
}
