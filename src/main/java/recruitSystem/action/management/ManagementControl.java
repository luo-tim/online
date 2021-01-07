/**
 * 
 */
package recruitSystem.action.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 72412 管理员控制
 */
@Controller
@RequestMapping("/managerPage")
public class ManagementControl {

	/*
	 * 进入管理员页面,显示管理员的各个功能
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String manager() {
		return "manager";
	}
//	/*
//	 * 查看用户的列表
//	 */
//	@RequestMapping(value="/userListPage",method=RequestMethod.GET)
//	public String userList() {
//		return "userList";
//	}
//	/*
//	 * 管理管理员
//	 */
//	@RequestMapping(value="/managerListPage",method=RequestMethod.GET)
//	public String managerList() {
//		return "managerList";
//	}
//	/*
//	 * 审核公司信息
//	 */
//	@RequestMapping(value="/checkCompanyPage",method=RequestMethod.GET)
//	public String checkCompany() {
//		return "checkCompany";
//	}
//	/*
//	 * 审核招聘信息
//	 */
//	@RequestMapping(value="/checkRecruitmentPage",method=RequestMethod.GET)
//	public String checkRecruitment() {
//		return "checkRecruitment";
//	}
}
