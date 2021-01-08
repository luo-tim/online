/**
 * 
 */
package recruitSystem.dao.companyInfo;

import org.apache.ibatis.annotations.Param;

/**
 * @author 72412
 *公司的DAO层操作
 */
public interface CompanyInfoDAO {

	/**
	 * 公司里注册一个HR
	 */
	int insert(@Param("userId")int userId,@Param("companyId")int companyId);
	
	/**
	 * 查找公司
	 */
	String findCompany(@Param("companyName")String companyName);
	
	void insertHR(@Param("userId")String userId,@Param("companyId")String companyId);
	void updateBossNum(@Param("companyId")String companyId);
}
