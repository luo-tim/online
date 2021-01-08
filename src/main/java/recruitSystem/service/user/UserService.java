/**
 * 
 */
package recruitSystem.service.user;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.companyInfo.CompanyInfoDAO;
import recruitSystem.dao.userInfo.UserInfoDAO;
import recruitSystem.view.User;

/**
 * @author 72412
 *用户服务
 */
@Service("UserService")
public class UserService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	@Autowired
	private CompanyInfoDAO companyInfoDAO;
		
	/**
	 * 用户登录，验证账号密码是否正确
	 * @param account
	 * @param password
	 * @return
	 */
	public User selectUser(String account,String password) {
		return userInfoDAO.selectUser(account, password);
	}
	
	/**
	 * 判断用户是否存在
	 * @param account
	 * @return
	 */
	public int countUser(String account) {
		
		return userInfoDAO.countUser(account);
		
	}
	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	public void insert(User user) {
		userInfoDAO.insert(user);
	}
	
	/**
	 * 注册新用户
	 * @param user
	 * @param companyId
	 * @return
	 */
	public void insert(User user,String companyId) {
		userInfoDAO.insert(user);
		companyInfoDAO.insertHR(user.getId(),companyId);
		companyInfoDAO.updateBossNum(companyId);
	}
	
	public void updateUserName(String userName,String account) {
		userInfoDAO.updateUserName(userName, account);
	}
	
	public void updateBasicInfo(User user) {
		userInfoDAO.updateBasicInfo(user);
	}
	
	public User findUser(String userId) {
		return null;
	}
	
	
	public int deleteUser(String userId) {
		return 0;
	}
	
	public void updateManager(String userId) {
		
	}
	public List<User> findSignupUsers(String id) {
		return null;
	}
	
	public int successWorker(int flag, String workerId, String employmentId, String date) {
		return 0;
	}
}
