/**
 * 
 */
package recruitSystem.action.management;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.job.JobService;
import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Company;
import recruitSystem.view.Job;
import recruitSystem.view.User;

/**
 * @author 72412
 * 管理员审查公司信息控制,审查信息分为通过和审核中
 */
@Controller
@RequestMapping("/managerPage/checkCompanyPage")
public class ManagementCheckCompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private JobService jobService;
	
	/*
	 * 查看公司列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String CompanyList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value = "tag", defaultValue = "3") String tag, Model model) {
		PaginationSupport<Company> companies = companyService.fingCompanies(pageNo,tag);
		model.addAttribute("pages", companies);
		return "manager/checkCompany";
	}
	

	/*
	 * 审核通过
	 */
	@RequestMapping(value = "/successCompanyPage", method = RequestMethod.GET)
	public String successCompany(@RequestParam(value = "companyId", defaultValue = "0") String companyId,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
	
		companyService.successCompany(companyId, user.getId());
		
		return "redirect:/managerPage/checkCompanyPage";
	}

	
	/*
	 * 审核不通过
	 */
	@RequestMapping(value = "/failCompanyPage", method = RequestMethod.GET)
	public String failCompany(@RequestParam(value = "companyId", defaultValue = "0") String companyId, Model model) {
		companyService.failCompany(companyId);
		return "redirect:/managerPage/checkCompanyPage";
	}
	
	/*
	 * 查看公司的详情页面
	 */
	@RequestMapping(value = "/companyDetailPage", method = RequestMethod.GET)
	public String companyDetail(@RequestParam(value = "companyId", defaultValue = "0") String companyId, Model model) {
		Company company = companyService.findCompanyById(companyId);
		model.addAttribute("company", company);
		model.addAttribute("index", 0);
		return "company/companyDetail";
	}

	/*
	 * 公司的工作详情
	 */
	@RequestMapping(value = "/jobsDetailPage", method = RequestMethod.GET)
	public String jobsDetail(@RequestParam(value = "companyId", defaultValue = "0") String companyId, Model model) {
		Company company = companyService.findCompanyById(companyId);
		model.addAttribute("company", company);
		List<Job> jobs = jobService.findCompanyJobs(companyId);
		model.addAttribute("jobs", jobs);
		model.addAttribute("index", 1);
		return "company/companyDetail";
	}

}
