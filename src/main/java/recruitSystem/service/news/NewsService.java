/**
 * 
 */
package recruitSystem.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.news.NewsDAO;
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
	
	public void sendMessage(Information information) {
		
	}
	
	public List<User> findSendUser(String receiveId ) {
		return newsDAO.selectBySendUser(receiveId);
	}
	
	public List<Information> findInformations(String sendId, String receiveId) {
		return newsDAO.selectBySendnReceive(sendId,receiveId);
	}
	
	public void save(Information information) {
		
	}
}
