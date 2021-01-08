/**
 * 
 */
package recruitSystem.dao.userInfo;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.User;

/**
 * @author 72412
 *用户的DAO层操作
 */
public interface UserInfoDAO {

	/**
	 *  用户登录，验证账号密码是否正确
	 * @param account
	 * @param password
	 * @return
	 */
	User selectUser(@Param("account") String account, @Param("password") String password);
	
	/**
	 * 验证账户是否存在
	 * @param account
	 * @return
	 */
	int countUser(@Param("account")String account);
	
	void insert(@Param("user")User user);
	
	void updateUserName(@Param("userName") String userName,@Param("account")String account);
	
	void updateBasicInfo(@Param("user")User user);
	
}
