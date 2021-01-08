/**
 * 
 */
package recruitSystem.service.companys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.companyInfo.CompanyInfoDAO;
import recruitSystem.view.Company;

/**
 * @author 72412
 *公司服务类
 */
@Service("CompanyService")
public class CompanyService {

	@Autowired
	private CompanyInfoDAO companyInfoDAO;
	/**
	 * 查找公司id
	 */
	public String findCompany(String companyName) {
		String id=companyInfoDAO.findCompany(companyName);
		return id;
	};
	
	
	/**
	 * 查找公司列表
	 */
	
	public List<Company> findCompanies(){
		return null;
	}
	
	/**
	 * 根据公司id查找公司
	 */
	
	public Company findCompanyById(String companyId) {
		return null;
	}
	
	public Company findCompanyByBossId(String bossId) {
		return null;
	}
	
	public void insert(Company company) {
		
	}
	
	
	public void successCompany(String companyId,String userId) {
		
	}
	
	public void failCompany(String companyId) {
		
	}
	
}
