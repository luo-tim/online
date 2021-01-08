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

	List<Job> findReleaseJob(@Param("id") String id,@Param("tag") int tag);
	List<Job> findSignupJob(@Param("id") String id,@Param("tag") int tag);
	List<Job> findHistoryJob(@Param("id") String id);
}
