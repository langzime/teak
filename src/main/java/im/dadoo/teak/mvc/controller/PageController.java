package im.dadoo.teak.mvc.controller;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.mvc.service.FileService;
import im.dadoo.teak.mvc.service.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@Autowired
	private PageService pas;
	
	@RequestMapping(value = "/admin/page", method = RequestMethod.POST)
	public String add(@RequestParam String name, @RequestParam String url, @RequestParam String title, 
			@RequestParam String author, @RequestParam String content) {
		Page page = new Page(name, url, title, author, content);
		this.pas.insert(page);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/page/{pageId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int pageId) {
		System.out.println(pageId);
		this.pas.deleteById(pageId);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/admin/page/{pageId}/update", method = RequestMethod.POST)
	public String update(@PathVariable int pageId, @RequestParam String name, @RequestParam String url,
			@RequestParam String title, @RequestParam String author, 
			@RequestParam String content, @RequestParam long publishTime) {
		Page page = new Page(name, url, title, author, content, publishTime);
		page.setId(pageId);
		this.pas.update(page);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/page/{pageId}", method = RequestMethod.GET)
	public String getPost(@PathVariable long pageId, ModelMap map) {
		Page page = this.pas.fetchById(pageId);
		if (page != null) {
			map.addAttribute("page", page);
			page.setClick(page.getClick() + 1);
			this.pas.update(page);
			return "page";
		}
		else {
			return "404";
		}
	}
}
