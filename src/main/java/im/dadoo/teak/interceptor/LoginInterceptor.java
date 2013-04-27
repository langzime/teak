package im.dadoo.teak.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import im.dadoo.teak.mvc.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		User user = (User)request.getSession().getAttribute("loginUser");
		if (user != null) {
			return true;
		}
		else {
			response.sendRedirect("/login");
			return false;
		}
	}
}
