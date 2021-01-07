/**
 * 
 */
package recruitSystem.view;

import java.util.Date;

/**
 * @author 72412
 *用户实体类，存储用户的基本信息
 */
public class User {
	private int id;//用户id
	private String userName;//用户名
	private String account;//用户账号
	private String password;//用户密码
	private String identity;//用户身份
	private int identityId;//用户身份id
	private int credit;//用户的信誉度
	private boolean enable;//用户是否禁用标识
	private String lastName;//用户的姓
	private String firstName;//用户的名
	private Date dateOfBirth;//用户出生日期
	private String birth;//用户出生日期
	private String IDNumber;//用户的身份证号
	private String phoneNumber;//用户的手机号
	private String email;//用户的邮箱
	private String sex;//用户的性别
	private int managerLevel;//管理员的级别
	private String companyName;//老板的公司
	
	
	/**
	 * @return the managerLevel
	 */
	public int getManagerLevel() {
		return managerLevel;
	}

	/**
	 * @param managerLevel the managerLevel to set
	 */
	public void setManagerLevel(int managerLevel) {
		this.managerLevel = managerLevel;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the iDNumber
	 */
	public String getIDNumber() {
		return IDNumber;
	}

	/**
	 * @param iDNumber the iDNumber to set
	 */
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @param identityId the identityId to set
	 */
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}

	/**
	 * @return the identityId
	 */
	public int getIdentityId() {
		return identityId;
	}

	/**
	 * @param identityId the identityId to set
	 */
	public void setIdentityId(Integer identityId) {
		this.identityId = identityId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
