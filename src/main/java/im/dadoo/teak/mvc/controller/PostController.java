package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.Post;
import im.dadoo.teak.mvc.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private PostService ps;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String add(@RequestParam String title, @RequestParam String author, 
			@RequestParam String content, @RequestParam int categoryId) {
		Post post = new Post(title, author, content, categoryId);
		this.ps.insert(post);
		return "redirect:/admin/post";
	}
	
	@RequestMapping(value = "/post/{postId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int postId) {
		System.out.println(postId);
		this.ps.deleteById(postId);
		return "redirect:/admin/post";
	}
}
