/**
 * 
 */
package recruitSystem.dao.userInfo;

import java.util.List;

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
	User findUser(@Param("userId")String userId);
	void deleteUser(@Param("userId")String userId);
	void updateManager(@Param("userId")String userId);
	
	/**
	 * 通过接收者查找发送者
	 * @see recruitSystem.service.news.Newservice
	 * @param sendId
	 * @return
	 */
	List<User> selectBySendUser(@Param("receiveId")String receiveId);

	List<User> findSignupUsers(@Param("jobId")String jobId);
	void alterSignUpFlag(@Param("flag")int flag,@Param("userId") String userId, @Param("jobId")String jobId,@Param("date") String date);
}
