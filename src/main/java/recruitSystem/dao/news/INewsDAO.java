package recruitSystem.dao.news;

import java.util.List;

import recruitSystem.view.Information;
import recruitSystem.view.User;

public interface INewsDAO {

	public int countSendUser(int userID);
	
	public List<User> selectBySendUser(int userID);
		
	public List<Information> selectBySendnReceive(int userID,int user2ID);
	
}
