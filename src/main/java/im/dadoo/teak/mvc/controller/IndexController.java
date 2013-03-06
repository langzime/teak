package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.model.Link;
import im.dadoo.teak.mvc.model.Page;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.LinkService;
import im.dadoo.teak.mvc.service.PageService;
import im.dadoo.teak.mvc.service.PostService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static Log log = LogFactory.getLog(IndexController.class);
	
	@Autowired
	private CategoryService cs;
	
	@Autowired
	private PageService pas;
	
	@Autowired
	private LinkService ls;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap map) {
		Category activity = this.cs.fetchByUrlWithAll("activity");
		Category imagenews = this.cs.fetchByUrlWithAll("imagenews");
		Category notice = this.cs.fetchByUrlWithAll("notice");
		Category roll = this.cs.fetchByUrlWithAll("roll");
		
		Page introduction = this.pas.fetchByName("introduction");
		List<Link> links = this.ls.list();
		
		map.addAttribute("imagenews", imagenews);
		map.addAttribute("activity", activity);
		map.addAttribute("notice", notice);
		map.addAttribute("roll", roll);
		map.addAttribute("introduction", introduction);
		map.addAttribute("links", links);
		
		return "index";
	}
}
