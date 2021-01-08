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
	 * 注册公司
	 * @param company
	 * @return
	 */
	int insert(Company company);
	
	/**
	 * 查找公司id
	 * @param companyName
	 * @return
	 */
	String findCompany(@Param("companyName")String companyName);
	
	/**
	 * 插入HR
	 * @param userId
	 * @param companyId
	 */
	void insertHR(@Param("userId")String userId,@Param("companyId")String companyId);
	
	/**
	 * 更新老板数量
	 * @param companyId
	 */
	void updateBossNum(@Param("companyId")String companyId);
	
	/**
	 * 查找公司列表
	 * @return
	 */
	List<Company> findCompanies();
	
	/**
	 * 根据公司id查找公司
	 * @return
	 */
	Company findCompanyById(@Param("companyId")String companyId);
	
	/**
	 * 根据老板id查找公司
	 * @param bossId
	 * @return
	 */
	Company findCompanyByBossId(@Param("bossId")String bossId);
	
	
	
	
	
	
	
	
	
}
