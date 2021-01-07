/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *工作实体类
 */
public class Job {

	private int id;//主键
	private String jobName;//工作的名字
	private String salary;//薪水
	private String city;//城市
	private String jobType;//工作类型
	private String experience;//工作经验要求
	private String education;//学历要求
	private int flag;  //工作的状态标识
	private String jobDescription;//工作描述
	private String workaddress;//工作地址
	private String jobRequest;//工作的具体要求
	private String releaseTime;//发布时间




	/**
	 * @return the releaseTime
	 */
	public String getReleaseTime() {
		return releaseTime;
	}

	/**
	 * @param releaseTime the releaseTime to set
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return the workaddress
	 */
	public String getWorkaddress() {
		return workaddress;
	}

	/**
	 * @param workaddress the workaddress to set
	 */
	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}

	/**
	 * @return the jobRequest
	 */
	public String getJobRequest() {
		return jobRequest;
	}

	/**
	 * @param jobRequest the jobRequest to set
	 */
	public void setJobRequest(String jobRequest) {
		this.jobRequest = jobRequest;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
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
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

}
