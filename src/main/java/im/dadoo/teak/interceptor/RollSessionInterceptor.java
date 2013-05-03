package im.dadoo.teak.interceptor;

import im.dadoo.teak.mvc.service.PostService;
import im.dadoo.teak.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class RollSessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private PostService pos;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(Util.ROLL_SESSION_NAME) == null) {
			session.setAttribute(Util.ROLL_SESSION_NAME, this.pos.list(Util.STATE_NORMAL));
		}
		return true;
	}
}
