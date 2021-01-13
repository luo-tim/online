/**
 * 
 */
package recruitSystem.service.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recruitSystem.dao.companyInfo.CompanyInfoDAO;
import recruitSystem.dao.job.JobInfoDAO;
import recruitSystem.dao.userInfo.UserInfoDAO;
import recruitSystem.util.MD5;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.User;

/**
 * @author 72412 用户服务
 */
@Service("UserService")
public class UserService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	@Autowired
	private CompanyInfoDAO companyInfoDAO;
	@Autowired
	private JobInfoDAO jobInfoDAO;

	/**
	 * 用户登录，验证账号密码是否正确
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public User selectUser(String account, String password) {
		return userInfoDAO.selectUser(account, password);
	}

	/**
	 * 判断用户是否存在
	 * 
	 * @param account
	 * @return
	 */
	public int countUser(String account) {

		return userInfoDAO.countUser(account);

	}

	/**
	 * 注册新用户
	 * 
	 * @param user
	 * @return
	 */
	public void insert(User user) {
		userInfoDAO.insert(user);
	}

	/**
	 * 注册新用户
	 * 
	 * @param user
	 * @param companyId
	 * @return
	 */
	public void insert(User user, String companyId) {
		userInfoDAO.insert(user);
		companyInfoDAO.insertHR(user.getId(), companyId);
		companyInfoDAO.updateBossNum(companyId, 1);
	}

	/**
	 * 更新用户名
	 * 
	 * @param userName
	 * @param account
	 */
	public void updateUserName(String userName, String account) {
		userInfoDAO.updateUserName(userName, account);
	}

	/**
	 * 更新基本信息
	 * 
	 * @param user
	 */
	public void updateBasicInfo(User user) {
		userInfoDAO.updateBasicInfo(user);
	}

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User findUser(String userId) {
		return userInfoDAO.findUser(userId);
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	@Transactional
	public void deleteUser(String userId) {
		userInfoDAO.deleteUser(userId);
		int identityId = userInfoDAO.findUserIdentityId(userId);
		if (identityId == 1) {// 删除的是老板
			String companyId = companyInfoDAO.findCompanyId(userId);
			int num = jobInfoDAO.count(userId);
			companyInfoDAO.updateBossNum(companyId, -1);
			companyInfoDAO.updateJobNum(companyId, -num);
		}

	}

	/**
	 * 升级管理员权限
	 * 
	 * @param userId
	 */
	public void updateManager(String userId) {
		userInfoDAO.updateManager(userId);
	}

	/**
	 * 获取申请的用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<User> findSignupUsers(String id) {
		return userInfoDAO.findSignupUsers(id);
	}

	/**
	 * 更改用户的申请状态
	 * 
	 * @param flag
	 * @param userId
	 * @param jobId
	 * @param date
	 */
	public void alterSignUpFlag(int flag, String userId, String jobId, String date) {
		userInfoDAO.alterSignUpFlag(flag, userId, jobId, date);
	}

	/**
	 * 获取用户列表
	 * 
	 * @param pageNo
	 * @param tag
	 * @return
	 */
	public PaginationSupport<User> findUsers(int pageNo, String tag) {
		int totalCount = userInfoDAO.userCount(tag);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<User> users = userInfoDAO.findUsers(startIndex, tag);
		PaginationSupport<User> pu = new PaginationSupport<User>(users, totalCount, startIndex, pageNo);

		return pu;
	}

	/**
	 * 获取管理员列表
	 * 
	 * @param pageNo
	 * @return
	 */
	public PaginationSupport<User> findManagers(int pageNo) {
		int totalCount = userInfoDAO.ManagerCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<User> managers = userInfoDAO.findManagers(startIndex);

		PaginationSupport<User> pm = new PaginationSupport<User>(managers, totalCount, startIndex, pageNo);
		return pm;
	}

	/**
	 * 修改密码
	 * 
	 * @param account
	 * @param oldPassword
	 * @param password
	 */
	public void alterPassword(String account, String oldPassword, String password) {

		userInfoDAO.alterPassword(account, oldPassword, password);
	}

	/**
	 * 通过账号获取邮箱等信息
	 * 
	 * @param account
	 * @return
	 */
	public User findEmail(String account) {
		return userInfoDAO.findEmail(account);
	}

	/**
	 * 找回密码，修改密码
	 * 
	 * @param account
	 * @param newPassword
	 */
	public void findBackPassword(String account, String newPassword) {
		userInfoDAO.findBackPassword(account, newPassword);
	}

	/**
	 * 注册新用户
	 * 
	 * @param session
	 * @param userName
	 * @param account
	 * @param password
	 */
	@Transactional
	public void insert(HttpSession session, String userName, String account, String password) {
		User user = (User) session.getAttribute("newUser");
		user.setAccount(account);
		user.setPassword(MD5.md5(password));
		user.setUserName(userName);
		session.setAttribute("newUser", user);
		if (user.getIdentityId() == 1) {
			String companyId = (String) session.getAttribute("companyId");
			insert(user, companyId);
		} else {
			insert(user);
		}
	}
}
