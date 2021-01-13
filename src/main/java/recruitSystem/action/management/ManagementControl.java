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

	/**
	 * 进入管理员页面,显示管理员的各个功能
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String manager() {
		return "manager/manager";
	}

}
