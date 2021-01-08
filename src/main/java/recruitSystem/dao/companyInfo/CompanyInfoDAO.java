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
	 * 查找公司
	 */
	String findCompany(@Param("companyName")String companyName);
	
	void insertHR(@Param("userId")String userId,@Param("companyId")String companyId);
	void updateBossNum(@Param("companyId")String companyId);
	
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
	 * @return
	 */
	Company findCompanyById(@Param("companyId")String companyId);
	
	/**
	 * 根据老板id查找公司
	 * @param bossId
	 * @return
	 */
	Company findCompanyByBossId(@Param("bossId")String bossId);
	
	void successCompany(@Param("companyId")String companyId,@Param("userId")String userId);
	void failCompany(@Param("companyId")String companyId);
	
}
