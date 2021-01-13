/**
 * 
 */
package recruitSystem.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.news.NewsDAO;
import recruitSystem.dao.userInfo.UserInfoDAO;
import recruitSystem.view.Information;
import recruitSystem.view.User;

/**
 * @author 72412
 *
 */
@Service("NewsService")
public class NewsService {

	@Autowired
	private NewsDAO newsDAO;
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	/**
	 * 发送消息
	 * @param information
	 */
	public void sendMessage(Information information) {
		newsDAO.insert(information);
	}
	
	
	/**
	 * 获取发送者列表
	 * @param receiveId
	 * @return
	 */
	public List<User> findSendUser(String receiveId ) {
		return userInfoDAO.selectBySendUser(receiveId);
	}
	
	/**
	 * 获取发送的信息
	 * @param sendId
	 * @param receiveId
	 * @return
	 */
	public List<Information> findInformations(String sendId, String receiveId) {
		return newsDAO.selectBySendnReceive(sendId,receiveId);
	}
	
	
	
}
