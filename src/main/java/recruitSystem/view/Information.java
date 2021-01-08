/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *消息实体类
 */
public class Information {
	
	private String id;  //主键

	
	private String context;//发送的内容
	private String postTime;//发送的时间

	private String sendId;//发送者ID
	private String receiveId;//接收者ID

	/**
	 * @return the sendId
	 */
	public String getSendId() {
		return sendId;
	}

	/**
	 * @param sendId the sendId to set
	 */
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	/**
	 * @return the receiveId
	 */
	public String getReceiveId() {
		return receiveId;
	}

	/**
	 * @param receiveId the receiveId to set
	 */
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the postTime
	 */
	public String getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime the postTime to set
	 */
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	

}
