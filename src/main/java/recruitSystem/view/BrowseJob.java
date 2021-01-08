/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *工人的浏览记录
 */
public class BrowseJob {
	private String browseId;//主键
	private String browseTime;//浏览时间
	private String userId;//工人id
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
	 * @return the browseId
	 */
	public String getBrowseId() {
		return browseId;
	}
	/**
	 * @param browseId the browseId to set
	 */
	public void setBrowseId(String browseId) {
		this.browseId = browseId;
	}
	/**
	 * @return the browseTime
	 */
	public String getBrowseTime() {
		return browseTime;
	}
	/**
	 * @param browseTime the browseTime to set
	 */
	public void setBrowseTime(String browseTime) {
		this.browseTime = browseTime;
	}
	
}
