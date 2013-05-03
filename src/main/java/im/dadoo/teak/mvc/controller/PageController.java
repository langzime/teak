package im.dadoo.teak.mvc.controller;

import java.util.List;

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
	public String add(@RequestParam String name, @RequestParam String title, 
			@RequestParam String author, @RequestParam String html) {
		this.pas.save(name, title, author, html);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/page/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		this.pas.deleteById(id);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/admin/page/{id}/update", method = RequestMethod.POST)
	public String update(@PathVariable Long id, @RequestParam String name,
			@RequestParam String title, @RequestParam String author, @RequestParam String html) {

		this.pas.update(id, name, title, author, html);
		return "redirect:/admin/pages";
	}
	
	@RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
	public String getPost(@PathVariable Long id, ModelMap map) {
		Page page = this.pas.visit(id);
		if (page != null) {
			map.addAttribute("page", page);
			return "page";
		}
		else {
			return "404";
		}
	}
	
	@RequestMapping(value = "/admin/pages", method = RequestMethod.GET)
	public String getPageAdminPage(ModelMap map) {
		List<Page> pages = this.pas.list();
		map.addAttribute("pages", pages);
		return "admin/page-list";
	}
	
	@RequestMapping(value = "/admin/page", method = RequestMethod.GET)
	public String getPageAddPage() {
		return "admin/page";
	}
	
	@RequestMapping(value = "/admin/page/{pageId}/update", method = RequestMethod.GET)
	public String getPageUpdatePage(@PathVariable Long pageId, ModelMap map) {
		Page page = this.pas.fetchById(pageId);
		map.addAttribute("page", page);
		return "admin/page";
	}
}
