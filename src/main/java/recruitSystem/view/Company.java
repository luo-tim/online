/**
 * 
 */
package recruitSystem.view;

import java.util.List;

/**
 * @author 72412
 *公司实体类
 */
public class Company {

	private String id;  //主键

	private String companyDescription;//公司描述
	private String leaderIntroduce;//公司老总介绍
	private String companyName; //公司名称
	private String address;  //公司地址
	private int bossNum;  //HR数量
	private int jobNum;  //工作数量

	private String treatment;  //公司待遇

	private String companyType;  //公司类型

	private String companyLogo;   //公司图标
	private int flag;   //公司的状态
	private String mid;  //审核的管理员id
	private List<User> bosses;//公司的HR列表


	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * @return the bosses
	 */
	public List<User> getBosses() {
		return bosses;
	}

	/**
	 * @param bosses the bosses to set
	 */
	public void setBosses(List<User> bosses) {
		this.bosses = bosses;
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
	 * @return the bossNum
	 */
	public int getBossNum() {
		return bossNum;
	}

	/**
	 * @param bossNum the bossNum to set
	 */
	public void setBossNum(int bossNum) {
		this.bossNum = bossNum;
	}

	/**
	 * @return the jobNum
	 */
	public int getJobNum() {
		return jobNum;
	}

	/**
	 * @param jobNum the jobNum to set
	 */
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	/**
	 * @return the leaderIntroduce
	 */
	public String getLeaderIntroduce() {
		return leaderIntroduce;
	}

	/**
	 * @param leaderIntroduce the leaderIntroduce to set
	 */
	public void setLeaderIntroduce(String leaderIntroduce) {
		this.leaderIntroduce = leaderIntroduce;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the companyType
	 */
	public String getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	/**
	 * @return the companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyDescription
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * @param companyDescription the companyDescription to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
}
