/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *工人申请的工作
 */
public class SignUpJob {

	private String signUpId;//主键
	private String signUpTime;//申请的时间
	private String flag;//申请状态
	private String userId;//用户id
	private String jobId;//工作id
	
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the signUpId
	 */
	public String getSignUpId() {
		return signUpId;
	}
	/**
	 * @param signUpId the signUpId to set
	 */
	public void setSignUpId(String signUpId) {
		this.signUpId = signUpId;
	}
	/**
	 * @return the signUpTime
	 */
	public String getSignUpTime() {
		return signUpTime;
	}
	/**
	 * @param signUpTime the signUpTime to set
	 */
	public void setSignUpTime(String signUpTime) {
		this.signUpTime = signUpTime;
	}
	
}
