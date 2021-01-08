/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *工人的浏览记录
 */
public class BrowseJob extends Job{
	private String browseId;//主键
	private String browseTime;//浏览时间
	
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
