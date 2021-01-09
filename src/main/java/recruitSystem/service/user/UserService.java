/**
 * 
 */
package recruitSystem.service.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.companyInfo.CompanyInfoDAO;
import recruitSystem.dao.userInfo.UserInfoDAO;
import recruitSystem.util.PaginationSupport;
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
		return userInfoDAO.findUser(userId);
	}
	
	
	public void deleteUser(String userId) {
		userInfoDAO.deleteUser(userId);
	}
	
	public void updateManager(String userId) {
		userInfoDAO.updateManager(userId);
	}
	public List<User> findSignupUsers(String id) {
		return userInfoDAO.findSignupUsers(id);
	}
	
	public void alterSignUpFlag( int flag,String userId, String jobId, String date) {
		userInfoDAO.alterSignUpFlag(flag,userId,jobId, date);
	}
	
	public PaginationSupport<User> findUsers(int pageNo,String tag){
		int totalCount=userInfoDAO.userCount(tag);
		int startIndex=PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<User> users =userInfoDAO.findUsers(startIndex,tag);
		PaginationSupport<User> pu = new PaginationSupport<User>(users, totalCount, startIndex, pageNo);

		return pu;
	}
	public PaginationSupport<User> findManagers(int pageNo){
		int totalCount=userInfoDAO.ManagerCount();
		int startIndex=PaginationSupport.convertFromPageToStartIndex(pageNo);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<User> managers = userInfoDAO.findManagers(startIndex);
	
		PaginationSupport<User> pm=new PaginationSupport<User>(managers, totalCount,startIndex,pageNo);
		return pm;
	}
}
