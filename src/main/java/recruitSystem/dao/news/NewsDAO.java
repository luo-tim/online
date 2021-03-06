package recruitSystem.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.Information;

public interface NewsDAO {

	/**
	 * 通过发送、接收者查找消息
	 * @param sendId
	 * @param receiveId
	 * @return
	 */
	public List<Information> selectBySendnReceive(@Param("sendId")String sendId,@Param("receiveId")String receiveId);
	

	/**
	 * 插入消息
	 * @param information
	 * @return
	 */
	public int insert(@Param("information")Information information);
	
	/**
	 * 更新消息
	 * @param information
	 * @return
	 */
	public int update(Information information);
}
