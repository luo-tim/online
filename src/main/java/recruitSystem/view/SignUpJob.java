/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *工人申请的工作
 */
public class SignUpJob extends Job {

	private String signUpId;//主键
	private String signUpTime;//申请的时间
	
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
