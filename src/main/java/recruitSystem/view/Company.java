/**
 * 
 */
package recruitSystem.view;

/**
 * @author 72412
 *
 */
public class Company {

	private int id;

	private String companyDescription;
	private String leaderIntroduce;
	private String companyName;
	private String address;
	private int bossNum;
	private int jobNum;

	private String treatment;

	private String companyType;

	private String companyLogo;
	private int flag;

	public Company() {

	}

	public Company(int id, String companyName, String companyType, String companyLogo, int flag) {
		this.id = id;
		this.companyName = companyName;
		this.flag = flag;
		this.companyLogo = companyLogo;
		this.companyType = companyType;
	}

	public Company(int id, String companyDescription) {
		this.id = id;
		this.companyDescription = companyDescription;
	}

	public Company(int id, String companyName, String description, String address, String treatment, String companyType,
			String companyLogo, String leaderIntroduce, int flag) {
		this.id = id;
		this.companyDescription = description;
		this.companyName = companyName;
		this.treatment = treatment;
		this.address = address;
		this.companyLogo = companyLogo;
		this.companyType = companyType;
		this.leaderIntroduce = leaderIntroduce;
		this.flag = flag;
	}

	public Company(String companyName, String description, String address, String treatment, String companyType,
			String companyLogo, String leaderIntroduce) {
		this.companyDescription = description;
		this.companyName = companyName;
		this.treatment = treatment;
		this.address = address;
		this.companyLogo = companyLogo;
		this.companyType = companyType;
		this.leaderIntroduce = leaderIntroduce;

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
