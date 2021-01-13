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

	/**
	 * 查找发布的工作
	 * @param id
	 * @param tag
	 * @return
	 */
	List<Job> findReleaseJob(@Param("id") String id,@Param("tag") String tag);
	/**
	 * 查找申请的工作
	 * @param id
	 * @param tag
	 * @return
	 */
	List<Job> findSignupJob(@Param("id") String id,@Param("tag") String tag);
	/**
	 * 查找历史浏览的工作
	 * @param id
	 * @return
	 */
	List<Job> findHistoryJob(@Param("id") String id);
	/**
	 * 查找工作根据工作id
	 * @param jobId
	 * @return
	 */
	Job findJob(@Param("jobId") String jobId);
	/**
	 * 查找历史记录是否存在
	 * @param userId
	 * @param jobId
	 * @return
	 */
	int existHistory(@Param("userId") String userId,@Param("jobId")String jobId);
	/**
	 * 获取申请的状态
	 * @param userId
	 * @param jobId
	 * @return
	 */
	String findSignUpFlag(@Param("userId") String userId,@Param("jobId")String jobId);
	/**
	 * 更新浏览记录
	 * @param browseJob
	 */
	void updateHistory(@Param("browseJob") BrowseJob browseJob);
	/**
	 * 添加浏览记录
	 * @param browseJob
	 */
	void insertHistory(@Param("browseJob") BrowseJob browseJob);
	/**
	 * 工人申请工作
	 * @param signUpJob
	 */
	void insertWorkerSignup(@Param("signUpJob")SignUpJob signUpJob);
	/**
	 * 根据jobId获取bossId
	 * @param jobId
	 * @return
	 */
	String getBossId(@Param("jobId")String jobId);
	/**
	 * 工作审核通过
	 * @param userId
	 * @param jobId
	 */
	void successJobs(@Param("userId")String userId,@Param("jobId")String jobId);
	/**
	 * 工作审核失败
	 * @param jobId
	 */
	void failJobs(@Param("jobId")String jobId);
	/**
	 * 删除工作
	 * @param jobId
	 */
	void deleteJob(@Param("jobId")String jobId);
	/**
	 * 查找公司的工作
	 * @param companyId
	 * @return
	 */
	List<Job> findCompanyJobs(@Param("companyId")String companyId);
	/**
	 * 插入工作,返回工作id
	 * @param job
	 * @return
	 */
	int insert(Job job);
	/**
	 * 老板查看自己的工作页面
	 * @param jobId
	 * @return
	 */
	Job findBossJob(@Param("jobId")String jobId);
	
	/**
	 * 结束招聘 
	 * @param jobId
	 */
	void updateJobFinshed(@Param("jobId")String jobId);
	/**
	 * 获取工作数量
	 * @param flag
	 * @param query
	 * @param city
	 * @param type
	 * @return
	 */
	int jobCount(@Param("flag")String flag,@Param("query") String query, @Param("city")String city, @Param("type")String type);
	/**
	 * 获取工作列表
	 * @param startIndex
	 * @param tag
	 * @param query
	 * @param city
	 * @param type
	 * @return
	 */
	List<Job> findJobs(@Param("startIndex")int startIndex,@Param("tag")String tag,@Param("query") String query, @Param("city")String city, @Param("type")String type);
	/**
	 * 获取工作的状态
	 * @param jobId
	 * @return
	 */
	String findFlag(@Param("jobId")String jobId);
	/**
	 * 根据job  id获取bossId
	 * @param jobId
	 * @return
	 */
	String findBossId(String jobId);
	/**
	 * 获取老板的工作数量
	 * @param userId
	 * @return
	 */
	int count(@Param("userId")String userId);
	
}
