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
	
	public void sendMessage(Information information) {
		newsDAO.insert(information);
	}
	
	public List<User> findSendUser(String receiveId ) {
		return userInfoDAO.selectBySendUser(receiveId);
	}
	
	public List<Information> findInformations(String sendId, String receiveId) {
		return newsDAO.selectBySendnReceive(sendId,receiveId);
	}
	
	public void save(Information information) {
		List<Information> informations = newsDAO.selectBySendnReceive(
				information.getSendId(), information.getReceiveId());
		Boolean exist = false;
		for (Information information2 : informations) {
			if (information.getId().equals(information2.getId())) {//已存在，更新
				newsDAO.update(information);
				exist=true;
				break;
			}
		}
		if (!exist) {//不存在，插入
			newsDAO.insert(information);
		}
	}
}
