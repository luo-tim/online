/**
 * 
 */
package recruitSystem.dao.companyInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import recruitSystem.view.Company;

/**
 * @author 72412
 *公司的DAO层操作
 */
public interface CompanyInfoDAO {


	/**
	 * 查找公司id
	 * 
	 * @param companyName
	 * @return
	 */
	String findCompany(@Param("companyName")String companyName);
	/**
	 * 插入公司和HR的关联
	 * @param userId
	 * @param companyId
	 */
	void insertHR(@Param("userId")String userId,@Param("companyId")String companyId);
	
	
	/**
	 * 更新公司HR的数量
	 * @param companyId
	 * @param num
	 */
	void updateBossNum(@Param("companyId")String companyId,@Param("num")int num);
	
	/**
	 * 注册公司
	 * @param company
	 * @return
	 */
	int insert(Company company);
	/**
	 * 查找公司列表
	 * @return
	 */
	List<Company> findCompanies();
	
	
	/**
	 * 根据公司id查找公司
	 * @param companyId
	 * @param flag
	 * @return
	 */
	Company findCompanyById(@Param("companyId")String companyId,@Param("flag")String flag);
	
	/**
	 * 根据老板id查找公司
	 * @param bossId
	 * @return
	 */
	Company findCompanyByBossId(@Param("bossId")String bossId);
	/**
	 * 公司审核通过
	 * @param companyId
	 * @param userId
	 */
	void successCompany(@Param("companyId")String companyId,@Param("userId")String userId);
	
	/**
	 * 公司审核不通过
	 * @param companyId
	 */
	void failCompany(@Param("companyId")String companyId);
	/**
	 * 获取公司的数量
	 * @param tag
	 * @return
	 */
	int CompanyCount(@Param("tag")String tag);
	/**
	 * 管理员获取公司列表
	 * @param startIndex
	 * @param tag
	 * @return
	 */
	List<Company> findManagerCompanies(@Param("startIndex")int startIndex,@Param("tag")String tag);
	/**
	 * 根据老板id获取公司id
	 * @param bossId
	 * @return
	 */
	String findCompanyId(@Param("bossId")String bossId);
	
	/**
	 * 更新HR数量
	 * @param companyId
	 * @param num
	 */
	void updateJobNum(@Param("companyId")String companyId,@Param("num")int num);
	/**
	 * 根据bossid获取公司名
	 * @param userId
	 * @return
	 */
	String findCompanyName(@Param("userId")String userId);
	
	
	
}
