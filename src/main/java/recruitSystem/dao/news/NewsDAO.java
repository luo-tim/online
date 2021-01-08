package recruitSystem.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.Information;
import recruitSystem.view.User;

public interface NewsDAO {

	/**
	 * 
	 * @param sendId
	 * @return
	 */
	public List<User> selectBySendUser(@Param("receiveId")String receiveId);
	
	/**
	 * 
	 * @param sendId
	 * @param receiveId
	 * @return
	 */
	public List<Information> selectBySendnReceive(@Param("sendId")String sendId,@Param("receiveId")String receiveId);
}
