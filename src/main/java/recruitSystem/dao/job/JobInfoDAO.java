/**
 * 
 */
package recruitSystem.dao.job;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.BrowseJob;
import recruitSystem.view.Job;
import recruitSystem.view.SignUpJob;

/**
 * @author 72412
 *
 */
public interface JobInfoDAO {

	List<Job> findReleaseJob(@Param("id") String id,@Param("tag") int tag);
	List<Job> findSignupJob(@Param("id") String id,@Param("tag") int tag);
	List<Job> findHistoryJob(@Param("id") String id);
	Job findJob(@Param("jobId") String jobId);
	int existHistory(@Param("usrId") String userId,@Param("jobId")String jobId);
	String findSignUpFlag(@Param("usrId") String userId,@Param("jobId")String jobId);
	void updateHistory(@Param("browseJob") BrowseJob browseJob);
	void insertHistory(@Param("browseJob") BrowseJob browseJob);
	void insertWorkerSignup(@Param("signUpJob")SignUpJob signUpJob);
	String getBossId(@Param("jobId")String jobId);
	void successJobs(@Param("userId")String userId,@Param("jobId")String jobId);
	void failJobs(@Param("jobId")String jobId);
	void deleteJob(@Param("jobId")String jobId);
	List<Job> findCompanyJobs(@Param("companyId")String companyId);
	int insert(Job job);
	Job findBossJob(@Param("jobId")String jobId);
	void updateJobFinshed(@Param("jobId")String jobId);
	
	int jobCount(@Param("flag")String flag,@Param("query") String query, @Param("city")String city, @Param("type")String type);
	List<Job> findJobs(@Param("startIndex")int startIndex,@Param("query") String query, @Param("city")String city, @Param("type")String type);
}
