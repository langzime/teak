package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.domain.Link;
import im.dadoo.teak.mvc.service.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {

	@Autowired
	private LinkService ls;
	
	@RequestMapping(value = "/admin/link", method = RequestMethod.POST)
	public String add(@RequestParam String url, @RequestParam String name, 
			@RequestParam String description) {
		this.ls.insert(new Link(url, name, description));
		return "redirect:/admin/links";
	}
	
	@RequestMapping(value = "/admin/link/{linkId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int linkId) {
		this.ls.deleteById(linkId);
		return "redirect:/admin/links";
	}
	
	@RequestMapping(value = "/admin/link/{linkId}/update", method = RequestMethod.POST)
	public String update(@PathVariable int linkId, @RequestParam String url, 
			@RequestParam String name, @RequestParam String description) {
		Link link = new Link(url, name, description);
		link.setId(linkId);
		this.ls.update(link);
		return "redirect:/admin/links";
	}
}
