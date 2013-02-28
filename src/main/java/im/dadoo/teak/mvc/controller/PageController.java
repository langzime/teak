package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.Page;
import im.dadoo.teak.mvc.service.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@Autowired
	private PageService pas;
	
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public String add(@RequestParam String name, @RequestParam String title, 
			@RequestParam String author, @RequestParam String content) {
		Page page = new Page(name, title, author, content);
		this.pas.insert(page);
		return "redirect:/admin/page";
	}
	
	@RequestMapping(value = "/page/{pageId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int pageId) {
		System.out.println(pageId);
		this.pas.deleteById(pageId);
		return "redirect:/admin/page";
	}
}
