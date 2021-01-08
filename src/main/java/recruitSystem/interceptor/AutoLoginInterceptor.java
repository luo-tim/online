/**
 * 
 * 该拦截器用于已登录的用户跳转至登录界面时，自动跳转至已登录的系统首页
 * 
 */
package recruitSystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import recruitSystem.view.User;



/**
 * @author 72412
 *
 */
public class AutoLoginInterceptor implements HandlerInterceptor {
	private final static Log log = LogFactory.getLog(AutoLoginInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("3.Called after rendering the view");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("2.Called after handler method request completion, before rendering the view");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		log.debug("1.Called before handler method");
		// 获取session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String identity =(String) session.getAttribute("identity");
		// 判断session中是否有用户数据，如果有，则不进入登陆界面而是直接跳转到已经登陆的系统首页
		if (user != null && identity.equals("boss")) {
			response.sendRedirect(request.getContextPath()+"/homePage");
			return false;
		}
		else if (user != null && identity.equals("manager")) {
			response.sendRedirect(request.getContextPath()+"/homePage");
			return false;
		}
		else if (user != null && identity.equals("worker")) {
			response.sendRedirect(request.getContextPath()+"/homePage");
			return false;
		}
		//若session中无用户数据，则继续执行下去。
		
		//  /loginPage
		//   /registerPage/accountInfoPage
		return true;
	}

}
