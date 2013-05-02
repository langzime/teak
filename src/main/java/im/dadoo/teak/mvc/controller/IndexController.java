package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Link;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.LinkService;
import im.dadoo.teak.mvc.service.PageService;
import im.dadoo.teak.mvc.service.PostService;
import im.dadoo.teak.util.Util;

import java.util.Collections;
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
	
	@Autowired
	private PostService pos;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap map) {
		Category activity = this.cs.fetchByName("学术活动");
		Category imagenews = this.cs.fetchByName("图片新闻");
		Category notice = this.cs.fetchByName("中心公告");
		//Category roll = this.cs.fetchByName("滚动新闻");
		Category research = this.cs.fetchByName("学术研究");
		
		Page introduction = this.pas.fetchByName("中心介绍");
		List<Link> links = this.ls.list();
		List<Post> roll = this.pos.list(Util.STATE_NORMAL);
		map.addAttribute("imagenews", imagenews);
		map.addAttribute("activity", activity);
		map.addAttribute("notice", notice);
		map.addAttribute("research", research);
		map.addAttribute("roll", roll);
		map.addAttribute("introduction", introduction);
		map.addAttribute("links", links);
		
		return "index";
	}
}
