package im.dadoo.teak.interceptor;


import im.dadoo.teak.mvc.service.MenuService;
import im.dadoo.teak.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CategorySessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private MenuService ms;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(Util.MENU_SESSION_NAME) == null) {
			session.setAttribute(Util.MENU_SESSION_NAME, this.ms.create());
		}
		return true;
	}
}
