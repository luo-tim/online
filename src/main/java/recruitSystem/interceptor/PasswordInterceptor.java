/**
 * 
 */
package recruitSystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 72412
 *密码拦截器
 */
public class PasswordInterceptor  implements HandlerInterceptor {

	/**
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	
		System.out.println(request.getRequestURI().toString());
		String validate = (String) session.getAttribute("validate");
	
		if (validate!=null &&validate.equals("root")) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/passwordPage/findPwAccountPage");
		return false;
	}

	/**
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		
	}

	/**
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		
	}

}
