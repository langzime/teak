package im.dadoo.teak.interceptor;


import im.dadoo.teak.mvc.service.LinkService;
import im.dadoo.teak.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LinkSessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private LinkService ls;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(Util.LINK_SESSION_NAME) == null) {
			session.setAttribute(Util.LINK_SESSION_NAME, this.ls.list());
		}
		return true;
	}
}
