package recruitSystem.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.news.INewsDAO;
import recruitSystem.view.Information;
import recruitSystem.view.User;

/**
 * 
 * @author LJTTT
 *
 */
@Service("NewsService")
public class NewsService {
	
	@Autowired
	private INewsDAO iNewsDAO;
	
	public List<User> findSendUser(int userID) {
		return iNewsDAO.selectBySendUser(userID);
	}
	
	public List<Information> findInformations(int userID, int user2ID) {
		return iNewsDAO.selectBySendnReceive(userID,user2ID);
	}
	
	public void save(Information information) {
		
	}
}
