package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.service.CategoryService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static Log log = LogFactory.getLog(IndexController.class);
	
	@Autowired
	private CategoryService cs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session) {
		
		return "index";
	}
}
