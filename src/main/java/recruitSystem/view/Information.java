/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *消息实体类
 */
public class Information {
	
	private int id;  //主键
	private int sendId;//发送者id
	private int receiveId;//接收者的id

	private String context;//发送的内容
	private String postTime;//发送的时间

	private String sendName;//发送者的名字

	private String receiveName;//接收者的名字


	/**
	 * @return the sendName
	 */
	public String getSendName() {
		return sendName;
	}

	/**
	 * @param sendName the sendName to set
	 */
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	/**
	 * @return the receiveName
	 */
	public String getReceiveName() {
		return receiveName;
	}

	/**
	 * @param receiveName the receiveName to set
	 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sendId
	 */
	public int getSendId() {
		return sendId;
	}

	/**
	 * @param sendId the sendId to set
	 */
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	/**
	 * @return the receiveId
	 */
	public int getReceiveId() {
		return receiveId;
	}

	/**
	 * @param receiveId the receiveId to set
	 */
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
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
