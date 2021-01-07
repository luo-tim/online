package recruitSystem.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.Information;
import recruitSystem.view.User;

/**
 * 
 * @author LJTTT
 *
 */
public interface INewsDAO {
	
	/**
	 * 
	 * @param sendId
	 * @return
	 */
	public List<User> selectBySendUser(@Param("sendId")int sendId);
	
	/**
	 * 
	 * @param sendId
	 * @param receiveId
	 * @return
	 */
	public List<Information> selectBySendnReceive(@Param("sendId")int sendId,@Param("receiveId")int receiveId);
	
}
