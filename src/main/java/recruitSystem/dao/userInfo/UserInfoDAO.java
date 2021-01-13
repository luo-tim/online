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
	
	/**
	 * 插入用户
	 * @param user
	 */
	void insert(@Param("user")User user);
	/**
	 * 更新用户名
	 * @param userName
	 * @param account
	 */
	void updateUserName(@Param("userName") String userName,@Param("account")String account);
	/**
	 * 更新用户基本信息
	 * @param user
	 */
	void updateBasicInfo(@Param("user")User user);
	/**
	 * 根据用户id获取用户
	 * @param userId
	 * @return
	 */
	User findUser(@Param("userId")String userId);
	/**
	 * 删除用户
	 * @param userId
	 */
	void deleteUser(@Param("userId")String userId);
	/**
	 * 将管理员升级为超级管理员
	 * @param userId
	 */
	void updateManager(@Param("userId")String userId);
	
	/**
	 * 通过接收者查找发送者
	 * @see recruitSystem.service.news.Newservice
	 * @param sendId
	 * @return
	 */
	List<User> selectBySendUser(@Param("receiveId")String receiveId);

	/**
	 * 根据工作id获取申请的用户
	 * @param jobId
	 * @return
	 */
	List<User> findSignupUsers(@Param("jobId")String jobId);
	/**
	 * 更改申请状态
	 * @param flag
	 * @param userId
	 * @param jobId
	 * @param date
	 */
	void alterSignUpFlag(@Param("flag")int flag,@Param("userId") String userId, @Param("jobId")String jobId,@Param("date") String date);
	/**
	 * 获取用户数量
	 * @param tag
	 * @return
	 */
	int userCount(@Param("tag")String tag);
	/**
	 * 获取用户列表
	 * @param startIndex
	 * @param tag
	 * @return
	 */
	List<User> findUsers(@Param("startIndex")int startIndex,@Param("tag")String tag);
	/**
	 * 获取管理员列表
	 * @return
	 */
	int ManagerCount();
	/**
	 * 获取管理员列表
	 * @param startIndex
	 * @return
	 */
	List<User> findManagers(@Param("startIndex") int startIndex);
	/**
	 * 获取用户的身份标识
	 * @param userId
	 * @return
	 */
	int findUserIdentityId(@Param("userId")String userId);
	
	/**
	 * 修改密码
	 * @param account
	 * @param oldPassword
	 * @param password
	 */
	void alterPassword(@Param("account")String account,@Param("oldPassword")String oldPassword,@Param("password")String password);
	/**
	 * 通过账号查询邮箱等相关信息
	 * @param account
	 * @return
	 */
	User findEmail(@Param("account")String account);
	/**
	 * 找回密码，修改密码
	 * @param account
	 * @param newPassword
	 */
	void findBackPassword(@Param("account")String account,@Param("newPassword")String newPassword);
}
