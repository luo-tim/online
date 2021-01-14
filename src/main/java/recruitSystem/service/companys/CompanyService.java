/**
 * 
 */
package recruitSystem.service.companys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import recruitSystem.dao.companyInfo.CompanyInfoDAO;
import recruitSystem.util.PaginationSupport;
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
	 * @param companyName
	 * @return
	 */
	public String findCompany(String companyName) {
		String id=companyInfoDAO.findCompany(companyName);
		return id;
	};
	
	
	/**
	 * 查找公司列表
	 * @return
	 */
	public List<Company> findCompanies(){
		return companyInfoDAO.findCompanies();
	}
	
	/**
	 * 根据公司id查找公司
	 * @param companyId
	 * @param flag
	 * @return
	 */
	public Company findCompanyById(String companyId,boolean flag) {
		if (flag) {
			return companyInfoDAO.findCompanyById(companyId,"1");
		}else {
			return companyInfoDAO.findCompanyById(companyId,null);
		}
		
	}
	
	/**
	 * 根据老板id查找公司
	 * @param bossId
	 * @return
	 */
	public Company findCompanyByBossId(String bossId) {
		return companyInfoDAO.findCompanyByBossId(bossId);
	}
	
	/**
	 * 插入公司
	 * @param company
	 */
	@Async
	public void insert(Company company) {
		companyInfoDAO.insert(company);
	}
	
	/**
	 * 公司审核通过
	 * @param companyId
	 * @param userId
	 */
	public void successCompany(String companyId,String userId) {
		companyInfoDAO.successCompany(companyId,userId);
	}
	
	/**
	 * 公司审核没通过
	 * @param companyId
	 */
	public void failCompany(String companyId) {
		companyInfoDAO.failCompany(companyId);
	}
	
	/**
	 * 获取公司列表
	 * @param pageNo
	 * @param tag
	 * @return
	 */
	public PaginationSupport<Company> fingCompanies(int pageNo,String tag){
		int totalCount=companyInfoDAO.CompanyCount(tag);
		int startIndex=PaginationSupport.convertFromPageToStartIndex(pageNo, 6);
		if (startIndex >= totalCount) {
			startIndex = 0;
			pageNo = 1;
		}
		List<Company> companies = null;
		companies = companyInfoDAO.findManagerCompanies(startIndex,tag);
		PaginationSupport<Company> pc=new PaginationSupport<Company>(companies, totalCount, startIndex, pageNo, 6);
		return pc;
	}
	


	/**
	 * 更新公司的HR人数
	 * @param bossId
	 * @param num
	 */
	public void updateJobNum(String bossId,int num) {
		String  companyId = companyInfoDAO.findCompanyId(bossId);
		companyInfoDAO.updateJobNum(companyId,num);
	}
	/**
	 * 根据bossid获取公司名
	 * @param userId
	 * @return
	 */
	public String findCompanyName(String userId) {
		return companyInfoDAO.findCompanyName(userId);
	
	}
}
